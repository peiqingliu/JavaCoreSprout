package com.spring.framework.wuqianqian.thread.thread5;

/**
 * @author liupeqing
 * @date 2019/1/18 19:00
 */
public class Test1 {

    public static ThreadLocal<String> t1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("为ThreadLocal类对象放入值:aaa");
            t1.set("aaaֵ");
        }
        System.out.println(t1.get());//aaa
        System.out.println(t1.get());//aaa
    }

}
