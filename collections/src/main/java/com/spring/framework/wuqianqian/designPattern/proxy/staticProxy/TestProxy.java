package com.spring.framework.wuqianqian.designPattern.proxy.staticProxy;

/**
 * 测试
 * @author liupeqing
 * @date 2019/2/14 10:22
 */
public class TestProxy {

    public static void main(String[] args) {
        //现在可以看到，代理模式可以在不修改被代理对象的基础上，
        //通过扩展代理类，进行一些功能的附加与增强。
        //值得注意的是，代理类和被代理类应该共同实现一个接口，或者是共同继承某个类。

        //其中Movie就是共同的接口
        //RealMovie是被代理的类，也是真正实现的类
        //Cinema是代理类，也实现了共同的接口
        Movie movie = new RealMovie();
        Cinema cinema = new Cinema(movie);
        cinema.play();

    }
}
