package com.spring.framework.wuqianqian.thread.thread2;

/**
 * @author liupeqing
 * @date 2019/1/15 20:20
 */
public class ThreadB extends Thread{

    private Service service;
    public ThreadB(Service service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printB();
    }

}
