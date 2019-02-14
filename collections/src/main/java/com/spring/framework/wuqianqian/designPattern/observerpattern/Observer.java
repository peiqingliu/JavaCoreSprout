package com.spring.framework.wuqianqian.designPattern.observerpattern;

/**
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时候，观察者的update()方法会被回调
 * @author liupeqing
 * @date 2019/2/14 14:49
 */
public interface Observer {

    public void update (String message);
}
