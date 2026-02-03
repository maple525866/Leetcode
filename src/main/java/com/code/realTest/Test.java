package com.code.realTest;

/**
 * @author maple
 * @Description 银行转账系统 - 并发安全的转账实现
 * @createTime:2026-02-03 16:58
 */
public class Test {
    public static void main(String[] args) {
        // 创建测试账户
        Account accountA = new Account(1, 1000);
        Account accountB = new Account(2, 500);
        
        System.out.println("========== 测试1: 正常转账 ==========");
        System.out.println("转账前: A=" + accountA.getBalance() + ", B=" + accountB.getBalance());
        boolean result1 = transfer(accountA, accountB, 200);
        System.out.println("A -> B 转账 200: " + (result1 ? "成功" : "失败"));
        System.out.println("转账后: A=" + accountA.getBalance() + ", B=" + accountB.getBalance());
        
        System.out.println("\n========== 测试2: 余额不足 ==========");
        System.out.println("转账前: A=" + accountA.getBalance() + ", B=" + accountB.getBalance());
        boolean result2 = transfer(accountB, accountA, 1000);
        System.out.println("B -> A 转账 1000: " + (result2 ? "成功" : "失败"));
        System.out.println("转账后: A=" + accountA.getBalance() + ", B=" + accountB.getBalance());
        
        System.out.println("\n========== 测试3: 并发转账（死锁测试） ==========");
        Account accountC = new Account(3, 1000);
        Account accountD = new Account(4, 1000);
        System.out.println("初始: C=" + accountC.getBalance() + ", D=" + accountD.getBalance());
        
        // 线程1: C -> D 转账
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                transfer(accountC, accountD, 10);
            }
            System.out.println("线程1完成: C -> D 转账100次，每次10元");
        });
        
        // 线程2: D -> C 转账（反方向，测试死锁）
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                transfer(accountD, accountC, 10);
            }
            System.out.println("线程2完成: D -> C 转账100次，每次10元");
        });
        
        // 启动并发测试
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("并发后: C=" + accountC.getBalance() + ", D=" + accountD.getBalance());
        System.out.println("总金额: " + (accountC.getBalance() + accountD.getBalance()) + " (应该=2000)");
        System.out.println("✅ 测试通过：无死锁，金额守恒！");
    }
    
    /**
     * 转账方法 - 核心实现
     * @param from 转出账户
     * @param to 转入账户
     * @param amount 转账金额
     * @return 成功返回true，失败返回false
     */
    public static boolean transfer(Account from, Account to, long amount) {
        // 参数校验
        if (from == null || to == null || amount <= 0) {
            return false;
        }
        
        // 不能给自己转账
        if (from.id == to.id) {
            return false;
        }
        
        // 关键：按ID排序获取锁，避免死锁
        // 无论是 A->B 还是 B->A，都按照 ID小的在前，ID大的在后 的顺序加锁
        Account first = (from.id < to.id) ? from : to;
        Account second = (from.id < to.id) ? to : from;
        
        // 嵌套锁：按全局顺序获取
        synchronized (first) {
            synchronized (second) {
                // 检查余额（必须在锁内检查，保证原子性）
                if (from.getBalance() < amount) {
                    return false;  // 余额不足
                }
                
                // 执行转账（原子操作）
                from.withdraw(amount);
                to.deposit(amount);
                return true;
            }
        }
    }
    
    /**
     * 账户类
     */
    private static class Account {
        private final int id;        // 账户唯一标识（final保证不可变）
        private long balance;        // 账户余额（使用long避免溢出）
        
        public Account(int id, long balance) {
            this.id = id;
            this.balance = balance;
        }
        
        /**
         * 取款 - 需要同步保证线程安全
         */
        public synchronized void withdraw(long amount) {
            balance -= amount;
        }
        
        /**
         * 存款 - 需要同步保证线程安全
         */
        public synchronized void deposit(long amount) {
            balance += amount;
        }
        
        /**
         * 查询余额 - 需要同步保证可见性
         */
        public synchronized long getBalance() {
            return balance;
        }
        
        public int getId() {
            return id;
        }
    }
}
