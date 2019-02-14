package com.spring.framework.wuqianqian.thread.thread1;

/**
 * 共享的对象
 * @author liupeqing
 * @date 2019/1/15 19:59
 */
public class HasSelfPrivateNum {

    private int num = 0;

    /**
     * synchronized 是对象锁，锁住的是一个类的实例，也就是对象。
     * 所以如果是多个对象，那每一个对象都有一把锁，就会互不影响。
     *
     * synchronized(this)锁代码块的时候，this仍然是改类的实例对象
     *
     * synchronized关键字加到static静态方法和synchronized(class)代码块上都是是给Class类上锁，而synchronized关键字加到非static静态方法上是给对象上锁。
     *
     * @param username
     */
    public synchronized void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                //如果去掉hread.sleep(2000)，那么运行结果就会显示为同步的效果
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
