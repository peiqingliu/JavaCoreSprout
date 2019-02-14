package com.spring.framework.wuqianqian.designPattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 3、定义被观察者，实现了Observerable接口，对Observerable接口的三个方法进行了具体实现，
 * 同时有一个List集合，用以保存注册的观察者，等需要通知观察者时，遍历该集合即可。
 * @author liupeqing
 * @date 2019/2/14 14:53
 */
public class WechatServer implements Observerable {

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> observers;

    private String message;

    public WechatServer(){
        observers = new ArrayList<>();
    }



    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    //遍历所有的观察者
    @Override
    public void notifyObserver() {

        for (Observer observer : observers){
            observer.update(message);
        }
    }


    public void setInfomation(String s){
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
