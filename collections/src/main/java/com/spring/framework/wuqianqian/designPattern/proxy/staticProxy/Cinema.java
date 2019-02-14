package com.spring.framework.wuqianqian.designPattern.proxy.staticProxy;

/**
 * Cinema 就是 Proxy 代理对象，它有一个 play() 方法。不过调用 play() 方法时，它进行了一些相关利益的处理，那就是广告
 * @author liupeqing
 * @date 2019/2/14 10:17
 */
public class Cinema implements Movie {

    private Movie realMovie;

    public Cinema(Movie movie){
        this.realMovie = movie;
    }

    @Override
    public void play() {
        //电影开始之前，插播广告
        advertisement(true);
        //放电影
        realMovie.play();
        //电影结束，插播广告
        advertisement(false);
    }

    /**
     * 广告
     */
    private void advertisement(boolean isStart){
        if (isStart){
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        }else {
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }
}
