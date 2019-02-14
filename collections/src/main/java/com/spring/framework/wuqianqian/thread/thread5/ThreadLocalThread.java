package com.spring.framework.wuqianqian.thread.thread5;

/**
 * @author liupeqing
 * @date 2019/1/18 19:20
 */
public class ThreadLocalThread extends Thread {

    /**
     *如果此处没有使用static修饰，此处将ai放到Threadlocal里面，保证每个ai都是自己线程的副本，不会相互影响
     ThreadB get value--->0
     ThreadA get value--->0
     ThreadC get value--->0
     ThreadA get value--->1
     ThreadB get value--->1
     ThreadC get value--->1
     ThreadB get value--->2
     ThreadA get value--->2
     ThreadC get value--->2
     *
     */
    /**
     * 如果是static修饰，属于类变量，用的是同一个引用
     * ThreadC get value--->0
     * ThreadA get value--->2
     * ThreadB get value--->1
     * ThreadC get value--->3
     * ThreadB get value--->4
     * ThreadA get value--->5
     * ThreadC get value--->6
     * ThreadB get value--->7
     * ThreadA get value--->8
     */
    private static    int ai = 0;

    public ThreadLocalThread(String name)
    {
        super(name);
    }

    public void run()
    {
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Tools.t1.set((ai++) + "");
                System.out.println(this.getName() + " get value--->" + Tools.t1.get());
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
