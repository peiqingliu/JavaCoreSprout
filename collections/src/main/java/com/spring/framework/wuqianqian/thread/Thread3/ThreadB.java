package com.spring.framework.wuqianqian.thread.Thread3;

/**
 * @author liupeqing
 * @date 2019/1/15 20:40
 */
public class ThreadB extends Thread{
    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        //从结果可以看出来，notify()执行后并不会立即释放锁。
                        //当方法wait()被执行后，锁自动被释放，
                        // 但执行完notify()方法后，锁不会自动释放。
                        // 必须执行完notify()方法所在的synchronized代码块后才释放。
                        lock.notify();
                        System.out.println("已发出通知！");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素!");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
