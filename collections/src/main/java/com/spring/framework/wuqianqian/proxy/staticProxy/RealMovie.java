package com.spring.framework.wuqianqian.proxy.staticProxy;

/**
 * 然后，我们要有一个真正的实现这个 Movie 接口的类，和一个只是实现接口的代理类。
 * 这个表示真正的影片。它实现了 Movie 接口，play() 方法调用时，影片就开始播放。
 * @author liupeqing
 * @date 2019/2/14 10:05
 */
public class RealMovie implements Movie {
    @Override
    public void play() {
        System.out.println("您正在观看电影 《唐伯虎点秋香》");
    }
}
