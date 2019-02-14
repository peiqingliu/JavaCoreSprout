package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 * @author liupeqing
 * @date 2019/2/13 19:25
 */
public class Test1 {

    public static void main(String[] args) {
        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape shape = ShapeFactory.getShape("CIRCLE");
        shape.draw();

        //但是每一次传入的都是产品类的全部路径，这样比较麻烦。
        //如果需要改善的话可以通过 反射+配置文件 的形式来改善，这种方式使用的也是比较多的。
        Shape shape1 = (Shape) ShapeFactory2.getClass(Circle.class);
        shape1.draw();
    }
}
