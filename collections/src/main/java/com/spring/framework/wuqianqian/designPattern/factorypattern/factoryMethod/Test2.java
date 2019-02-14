package com.spring.framework.wuqianqian.designPattern.factorypattern.factoryMethod;

import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Shape;

/**
 * @author liupeqing
 * @date 2019/2/13 19:43
 */
public class Test2 {
    public static void main(String[] args) {
        //Factory 是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
        //CircleFactory 这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象。
        Factory factory = new CircleFactory();

        //工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口
        Shape shape = factory.getShape();
        shape.draw();
    }
}
