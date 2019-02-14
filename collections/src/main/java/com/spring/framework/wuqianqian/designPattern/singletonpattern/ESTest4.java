package com.spring.framework.wuqianqian.designPattern.singletonpattern;

/**
 * @author liupeqing
 * @date 2019/2/13 19:07
 */
public class ESTest4 {

    public static void main(String[] args) {
        Singleton4 singleton4 = Singleton4.INSTANCE;
        singleton4.doSomething();
    }
}
