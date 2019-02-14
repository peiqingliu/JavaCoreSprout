package com.spring.framework.wuqianqian.thread.thread1;

/**
 * @author liupeqing
 * @date 2019/1/15 20:01
 */
public class RunTest {
    public static void main(String[] args) {

        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();

        /**
         * a set over!
         * b set over!
         * b num=200
         * 会停顿两秒在输出
         * a num=100
         *
         * 这是因为synchronized取得的锁都是对象锁，而不是把一段代码或方法当做锁。所以在上面的实例中，
         * 哪个线程先执行带synchronized关键字的方法，则哪个线程就持有该方法所属对象的锁Lock，
         * 那么其他线程只能呈等待状态，前提是多个线程访问的是同一个对象。本例中很显然是两个对象。
         *
         * 在本例中创建了两个HasSelfPrivateNum类对象，所以就产生了两个锁。
         * 当ThreadA的引用执行到addI方法中的runThread.sleep(2000)语句时，
         * ThreadB就会“乘机执行”。所以才会导致执行结果如上图所示（备注：由于runThread.sleep(2000)，“a num=100”停顿了两秒才输出）
         *
         */
        ThreadA athread = new ThreadA(numRef1);
        athread.start();

        ThreadB bthread = new ThreadB(numRef2);
        bthread.start();

    }
}
