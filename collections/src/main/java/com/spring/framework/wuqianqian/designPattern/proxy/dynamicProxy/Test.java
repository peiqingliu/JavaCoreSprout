package com.spring.framework.wuqianqian.designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author liupeqing
 * @date 2019/2/14 11:12
 */
public class Test {

    public static void main(String[] args) {
        MaotaiJiu maotaiJiu = new MaotaiJiu();
        InvocationHandler invocationHandler = new GuitaiA(maotaiJiu);
        //创建的代理类dynamicProxy
        /**动态代码涉及了一个非常重要的类 Proxy。正是通过 Proxy 的静态方法 newProxyInstance 才会动态创建代理。
         * public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         * 下面讲解它的 3 个参数意义。
         *
         * loader 自然是类加载器 此处为MaotaiJiu的类加载器
         * interfaces 代码要用来代理的接口  此处为MaotaiJiu的实现的接口
         * h 一个 InvocationHandler 对象
         * InvocationHandler 是一个接口，官方文档解释说，每个代理的实例都有一个与之关联的 InvocationHandler 实现类，
         * 如果代理的方法被调用，那么代理便会通知和转发给内部的 InvocationHandler 实现类，由它决定处理。
         * 此处的代理实现类就是GuitaiA，因为他实现了InvocationHandler
         *
         * InvocationHandler 内部只是一个 invoke() 方法，正是这个方法决定了怎么样处理代理传递过来的方法调用。
         * proxy 代理对象
         * method 代理对象调用的方法
         * args 调用的方法中的参数
         * 因为，Proxy 动态产生的代理会调用 InvocationHandler 实现类，所以 InvocationHandler 是实际执行者。

         */

        SellWine dynamicProxy =(SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),MaotaiJiu.class.getInterfaces(),invocationHandler);
        dynamicProxy.maiJu();

        Wuliangye wuliangye = new Wuliangye();
        InvocationHandler wuliangyeInv = new GuitaiA(wuliangye);
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(Wuliangye.class.getClassLoader(),Wuliangye.class.getInterfaces(),wuliangyeInv);
        dynamicProxy2.maiJu();
    }
}
