package com.spring.framework.wuqianqian.thread.thread2;

/**
 * @author liupeqing
 * @date 2019/1/15 20:20
 */
public class ThreadC extends Thread{

    private Service service;
    public ThreadC(Service service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printC();
    }

}
