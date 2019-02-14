package com.spring.framework.wuqianqian.designPattern.observerpattern;

/**
 * 定义具体观察者，微信公众号的具体观察者为用户User
 * @author liupeqing
 * @date 2019/2/14 15:01
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();

    }

    private void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
