package com.spring.framework.wuqianqian.thread.thread1;

/**
 * @author liupeqing
 * @date 2019/1/15 20:01
 */
public class ThreadB extends Thread{

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }

}
