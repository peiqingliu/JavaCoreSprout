package com.spring.framework.wuqianqian.designPattern.singletonpattern;

/**
 *
 * 我们知道synchronized关键字偏重量级锁。虽然在JavaSE1.6之后synchronized关键字进行了主要包括：
 * 为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升。
 *
 * 但是在程序中每次使用getInstance() 都要经过synchronized加锁这一层，
 * 这难免会增加getInstance()的方法的时间消费，而且还可能会发生阻塞。
 * 我们下面介绍到的 双重检查加锁版本 就是为了解决这个问题而存在的。

 * @author liupeqing
 * @date 2019/2/13 19:00
 */
public class Singleton3 {

    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    //保证多个线程能够看到uniqueInstance3,保证数据的可见性
    private static volatile Singleton3 uniqueInstance3;

    private Singleton3(){}

    private static Singleton3 getUniqueInstance3(){
        //检查实例，如果不存在，就进入同步代码块
        if (uniqueInstance3 == null){
            //只有第一次才彻底执行这里的代码
            synchronized (Singleton3.class){
                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if (uniqueInstance3 == null){
                    uniqueInstance3 = new Singleton3();
                }
            }
        }
        return uniqueInstance3;
    }


}
