package com.spring.framework.wuqianqian.proxy.dynamicProxy;

/**
 * @author liupeqing
 * @date 2019/2/14 11:07
 */
public class MaotaiJiu implements SellWine {
    @Override
    public void maiJu() {
        System.out.println("我卖得是茅台酒。");
    }
}
