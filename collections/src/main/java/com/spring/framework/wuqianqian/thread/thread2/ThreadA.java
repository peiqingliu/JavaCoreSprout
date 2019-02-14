package com.spring.framework.wuqianqian.thread.thread2;

/**
 * @author liupeqing
 * @date 2019/1/15 20:19
 */
public class ThreadA extends Thread{

    private Service service;
    public ThreadA(Service service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printA();
    }

}
