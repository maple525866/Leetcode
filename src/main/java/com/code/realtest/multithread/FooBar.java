package com.code.realtest.multithread;

/**
 * @author maple
 * @Description 1115. 交替打印 FooBar
 * @createTime:2026-02-07 00:38
 */
public class FooBar {
    private int n;
    private boolean flag = true;
    private final Object lock = new Object();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                while(!flag){
                    lock.wait();
                }
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                while(flag){
                    lock.wait();
                }
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }
}
