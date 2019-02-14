package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 * 创建一个绘画的接口，相当于基类
 * “Define an interface for creating an object,
 * but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.”
 * (在基类中定义创建对象的一个接口，让子类决定实例化哪个类。工厂方法让一个类的实例化延迟到子类中进行。)

 * @author liupeqing
 * @date 2019/2/13 19:18
 */
public interface Shape {

    public void draw();
}
