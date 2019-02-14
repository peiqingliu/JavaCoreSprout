package com.spring.framework.wuqianqian.thread.thread1;

/**
 * @author liupeqing
 * @date 2019/1/15 20:00
 */
public class ThreadA  extends Thread {
    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

}
