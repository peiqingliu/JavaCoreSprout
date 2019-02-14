package com.spring.framework.wuqianqian.thread.thread4;

/**
 * @author liupeqing
 * @date 2019/1/15 20:58
 */
public class TestJoin {

    /**
     * 可以看到子线程中后被执行，这里的例子只是一个简单的演示，我们想一下：假如子线程运行的结果被主线程运行需要怎么办？
     * sleep方法？ 当然可以，但是子线程运行需要的时间是不确定的，
     * 所以sleep多长时间当然也就不确定了。这里就需要使用join方法解决上面的问题。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        MyThread threadTest = new MyThread();
        threadTest.start();

        //Thread.sleep(?);//因为不知道子线程要花的时间这里不知道填多少时间
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }
    static public class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("我想先执行");
        }

    }
}
