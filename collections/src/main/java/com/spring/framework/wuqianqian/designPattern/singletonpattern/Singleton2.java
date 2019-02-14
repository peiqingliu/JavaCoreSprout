package com.spring.framework.wuqianqian.designPattern.singletonpattern;

/**
 * 懒汉式（非线程安全和synchronized关键字线程安全版本 ）
 * 所谓 “ 懒汉式” 就是说单例实例在第一次被使用时构建，而不是在JVM在加载这个类时就马上创建此唯一的单例实例。
 * @author liupeqing
 * @date 2019/2/13 18:57
 */
public class Singleton2 {

    private static Singleton2 uniqueInstance;

    private Singleton2(){}

    //没有加入synchronized关键字的版本是线程不安全的
    public static Singleton2 getUniqueInstance(){
        //判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
        if (uniqueInstance == null){
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }

    //但是上面这种方式很明显是线程不安全的，如果多个线程同时访问getInstance()方法时就会出现问题。
    // 如果想要保证线程安全，一种比较常见的方式就是在getInstance() 方法前加上synchronized关键字，
    // 如下：

    public static synchronized Singleton2 getUniqueInstance2(){
        //判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
        if (uniqueInstance == null){
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}
