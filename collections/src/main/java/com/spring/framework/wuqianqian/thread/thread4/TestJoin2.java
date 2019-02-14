package com.spring.framework.wuqianqian.thread.thread4;

/**
 * @author liupeqing
 * @date 2019/1/15 20:59
 */
public class TestJoin2 {

    public static void main(String[] args) throws InterruptedException {

        MyThread threadTest = new MyThread();
        threadTest.start();

        //Thread.sleep(?);//因为不知道子线程要花的时间这里不知道填多少时间
        //子线程使用了join（）方法，在这里join方法的作用就是主线程需要等待子线程执行完成之后再结束。
        threadTest.join();
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }
    static public class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("我想先执行");
        }

    }

}
