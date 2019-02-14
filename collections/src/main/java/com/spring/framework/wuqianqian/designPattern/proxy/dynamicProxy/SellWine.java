package com.spring.framework.wuqianqian.designPattern.proxy.dynamicProxy;

/**
 * 假设有一个大商场，商场有很多的柜台，有一个柜台卖茅台酒。我们进行代码的模拟
 *
 * SellWine 是一个接口，你可以理解它为卖酒的许可证。
 * @author liupeqing
 * @date 2019/2/14 11:06
 */
public interface SellWine {

    //卖酒
    public void maiJu();

}
