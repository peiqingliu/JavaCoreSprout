package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 * 创建工厂类
 * 简单工厂类
 * 创建一个可以绘制不同形状的绘图工具，可以绘制圆形，正方形，三角形，每个图形都会有一个draw()方法用于绘图.
 *
 * 简单工厂模式角色分配：
 * 1.工厂(Factory)角色 :简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类可以被外界直接调用，创建所需的产品对象。
 * 2.抽象产品(Product)角色 :简单工厂模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
 * 3.具体产品(Concrete Product)角色:简单工厂模式的创建目标，所有创建的对象都是充当这个角色的某个具体类的实例。

 * @author liupeqing
 * @date 2019/2/13 19:16
 */
public class ShapeFactory {  //角色

    // 使用 getShape 方法获取形状类型的对象
    //为什么要返回Shape类型呢，是因为子类都实现了该接口，
    // Shape为抽象产品
    public static Shape getShape(String shapeType){
        if (shapeType == null){
            return null;
        }
        //不区分大小写
        if (shapeType.equalsIgnoreCase("CIRCLE")){
            //为具体的产品
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    //这样的实现有个问题，如果我们新增产品类的话，就需要修改工厂类中的getShape（）方法，这很明显不符合 开放-封闭原则 。
}
