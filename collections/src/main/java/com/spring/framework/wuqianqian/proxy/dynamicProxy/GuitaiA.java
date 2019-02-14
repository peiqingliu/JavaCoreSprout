package com.spring.framework.wuqianqian.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 我们还需要一个柜台来卖酒：
 * GuitaiA 实现了 InvocationHandler 这个类
 * 实际上该类就是真实代理的类
 * @author liupeqing
 * @date 2019/2/14 11:08
 */
public class GuitaiA implements InvocationHandler {

    /**
     * pingTai是真正代理的对象，为什么使用Object呢，因为我们动态代理的时候，不确定具体的类是谁。
     */
    private Object pingTai;

    public GuitaiA(Object pingTai){
        this.pingTai = pingTai;
    }

    /**
     * InvocationHandler 内部只是一个 invoke() 方法，正是这个方法决定了怎么样处理代理传递过来的方法调用。
     *
     * proxy 代理对象
     * method 代理对象调用的方法
     * args 调用的方法中的参数
     * 因为，Proxy 动态产生的代理会调用 InvocationHandler 实现类，所以 InvocationHandler 是实际执行者。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
        method.invoke(pingTai,args);
        System.out.println("销售结束");
        return null;
    }
}
