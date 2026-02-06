package com.code.realtest.multithread;

/**
 * @author maple
 * @Description
 * @createTime:2026-02-06 21:38
 */
public class PrintABCWithSynchronized {
    private static final int TIMES = 10;
    private static final Object lock = new Object();
    // 0: A, 1: B, 2: C
    private static volatile int state = 0;

    private static void print(){
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                synchronized (lock){
                    try {
                        while (state != 0){
                            lock.wait();
                        }
                        System.out.print("A");
                        state = 1;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                synchronized (lock){
                    try {
                        while (state != 1){
                            lock.wait();
                        }
                        System.out.print("B");
                        state = 2;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                synchronized (lock){
                    try {
                        while (state != 2){
                            lock.wait();
                        }
                        System.out.print("C");
                        state = 0;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
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
