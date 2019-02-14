package com.spring.framework.wuqianqian.thread.Thread3;

/**
 * @author liupeqing
 * @date 2019/1/15 20:41
 */
public class RunTest {

    public static void main(String[] args) {

        /**
         * 从运行结果:”wait end 1521967322359”最后输出可以看出，notify()执行后并不会立即释放锁。
         * synchronized关键字可以将任何一个Object对象作为同步对象来看待，
         * 而Java为每个Object都实现了等待/通知（wait/notify）机制的相关方法，
         * 它们必须用在synchronized关键字同步的Object的临界区内。
         * 通过调用wait()方法可以使处于临界区内的线程进入等待状态，同时释放被同步对象的锁。
         * 而notify()方法可以唤醒一个因调用wait操作而处于阻塞状态中的线程，使其进入就绪状态。
         * 被重新唤醒的线程会视图重新获得临界区的控制权也就是锁，并继续执行wait方法之后的代码。
         * 如果发出notify操作时没有处于阻塞状态中的线程，那么该命令会被忽略。

         */
        try {
            Object lock = new Object();

            ThreadA a = new ThreadA(lock);
            a.start();

            Thread.sleep(50);

            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
