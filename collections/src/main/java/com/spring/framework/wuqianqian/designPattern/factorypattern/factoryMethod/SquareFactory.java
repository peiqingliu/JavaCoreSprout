package com.spring.framework.wuqianqian.designPattern.factorypattern.factoryMethod;

import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Shape;
import com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory.Square;

/**
 * @author liupeqing
 * @date 2019/2/13 19:42
 */
public class SquareFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
