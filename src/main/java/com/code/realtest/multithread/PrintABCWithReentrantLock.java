package com.code.realtest.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maple
 * @Description 三个线程分别打印 A、B、C，要求按顺序循环输出 ABCABC
 * 可以使用多种方式实现，比如：
 * 使用 synchronized + wait/notify
 * 使用 ReentrantLock + Condition
 * 使用 Semaphore（信号量）
 * 使用 AtomicInteger + 自旋（不推荐用于高并发）
 * @createTime:2026-02-06 20:39
 */
public class PrintABCWithReentrantLock {
    private static int count = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    // 0: A, 1: B, 2: C
    private static volatile int state = 0;

    private static void print(){
        Thread threadA = new Thread(() -> {
            for(int i = 0; i < count; i++){

                lock.lock();
                try{
                    while(state != 0){
                        // await()会释放锁
                        conditionA.await();
                    }

                    System.out.print("A");
                    state = 1;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }finally {
                    lock.unlock();
                }

            }
        });

        Thread threadB = new Thread(() -> {
            for(int i = 0; i < count; i++){
                lock.lock();

                try {
                    while(state != 1){
                        conditionB.await();
                    }
                    System.out.print("B");
                    state = 2;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for(int i = 0; i < count; i++){
                lock.lock();

                try {
                    while(state != 2){
                        conditionC.await();
                    }
                    System.out.print("C");
                    state = 0;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static void main(String[] args) {
        print();
    }
}
