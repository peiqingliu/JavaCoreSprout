package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 * 圆形
 * @author liupeqing
 * @date 2019/2/13 19:18
 */
public class Circle implements Shape{

    public Circle(){
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
