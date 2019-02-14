package com.spring.framework.wuqianqian.designPattern.observerpattern;

/**
 * 首先注册了三个用户，ZhangSan、LiSi、WangWu。公众号发布了一条消息"PHP是世界上最好用的语言！"，三个用户都收到了消息。
 *
 * 用户ZhangSan看到消息后颇为震惊，果断取消订阅，这时公众号又推送了一条消息，此时用户ZhangSan已经收不到消息，其他用户
 *
 * 还是正常能收到推送消息。
 * @author liupeqing
 * @date 2019/2/14 15:03
 */
public class Test {

    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();

        Observer zhangsan = new User("张三");
        Observer lisi = new User("李四");
        Observer wangwu = new User("王五");

        wechatServer.registerObserver(zhangsan);
        wechatServer.registerObserver(lisi);
        wechatServer.registerObserver(wangwu);

        //发出通知
        wechatServer.setInfomation("PHP是世界上最好用的语言！");

    }
}
