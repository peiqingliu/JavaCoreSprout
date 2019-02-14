package com.spring.framework.wuqianqian.designPattern.observerpattern;

/**
 * 抽象被观察者接口
 *  声明了添加、删除、通知观察者方法
 * @author liupeqing
 * @date 2019/2/14 14:48
 */
public interface Observerable {

    //添加观察者
    public void registerObserver(Observer observer);

    //删除观察者
    public void removeObserver(Observer observer);

    //通知观察者
    public void notifyObserver();
}
