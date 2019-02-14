package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 * 长方形
 * @author liupeqing
 * @date 2019/2/13 19:20
 */
public class Rectangle implements Shape {

    public Rectangle() {
        System.out.println("Rectangle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }

}
