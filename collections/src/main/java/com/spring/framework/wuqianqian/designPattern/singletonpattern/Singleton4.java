package com.spring.framework.wuqianqian.designPattern.singletonpattern;

/**
 * 饿汉式（枚举方式）
 * 它更简洁，自动支持序列化机制，绝对防止多次实例化
 * 推荐该种模式
 * @author liupeqing
 * @date 2019/2/13 19:05
 */
public enum Singleton4 {
    //定义一个枚举的元素，它就是 Singleton 的一个实例
    INSTANCE;

    public void doSomething(){
        System.out.println("hello world");
    }
}
