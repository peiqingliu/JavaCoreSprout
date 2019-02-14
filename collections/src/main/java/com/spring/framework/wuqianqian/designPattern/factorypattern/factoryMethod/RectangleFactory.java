package com.spring.framework.wuqianqian.designPattern.factorypattern.factoryMethod;

import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Rectangle;
import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Shape;

/**
 * 长方形工厂类
 * @author liupeqing
 * @date 2019/2/13 19:41
 */
public class RectangleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
