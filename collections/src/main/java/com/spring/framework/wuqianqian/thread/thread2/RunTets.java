package com.spring.framework.wuqianqian.thread.thread2;

/**
 * @author liupeqing
 * @date 2019/1/15 20:21
 */
public class RunTets {

    public static void main(String[] args) {
        /**
         * 运行结果B一定在A后面
         */
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        ThreadC c = new ThreadC(service);
        c.setName("C");
        c.start();
    }

}
