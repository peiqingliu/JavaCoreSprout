package com.spring.framework.wuqianqian.thread.thread5;

/**
 * @author liupeqing
 * @date 2019/1/18 19:21
 */
public class Test2 {

    public static void main(String[] args) {
        ThreadLocalThread a = new ThreadLocalThread("ThreadA");
        ThreadLocalThread b = new ThreadLocalThread("ThreadB");
        ThreadLocalThread c = new ThreadLocalThread("ThreadC");
        a.start();
        b.start();
        c.start();
    }
}
