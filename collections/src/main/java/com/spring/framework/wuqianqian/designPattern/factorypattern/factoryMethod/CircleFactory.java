package com.spring.framework.wuqianqian.designPattern.factorypattern.factoryMethod;

import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Circle;
import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Shape;

/**
 * 增加相关工厂类:
 *
 * 圆形工厂类
 * @author liupeqing
 * @date 2019/2/13 19:41
 */
public class CircleFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
