package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 * @author liupeqing
 * @date 2019/2/13 19:21
 */
public class Square implements Shape {

    public Square(){
        System.out.println("Square");
    }
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
