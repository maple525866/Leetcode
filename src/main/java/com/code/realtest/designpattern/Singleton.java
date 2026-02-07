package com.code.realtest.designpattern;

/**
 * @author maple
 * @Description 单例模式(懒汉式)
 * @createTime:2026-02-07 16:31
 */
public class Singleton {
    //1. 私有无参构造方法
    private Singleton(){}

    //2. 创建对象,使用volatile关键字防止指令重排序与保证变量可见性
    private static volatile Singleton instance;

    //3. 向外提供公共方法，可以获取单例对象
    public static Singleton getInstance() {
        if (instance == null) {
            //synchronized关键字修饰代码块保证只有一个线程可以创建单例对象
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
