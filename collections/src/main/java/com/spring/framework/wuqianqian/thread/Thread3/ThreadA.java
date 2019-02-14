package com.spring.framework.wuqianqian.thread.Thread3;

/**
 * @author liupeqing
 * @date 2019/1/15 20:40
 */
public class ThreadA extends Thread{
    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin "
                            + System.currentTimeMillis());
                    //等待了，使用另一个线程进行唤醒
                    //wait()方法 属于一个对象的
                    lock.wait();
                    System.out.println("wait end  "
                            + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
