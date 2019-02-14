package com.spring.framework.wuqianqian.designPattern.factorypattern.simpleFactory;

/**
 *  利用反射解决简单工厂每次增加新了产品类都要修改产品工厂的弊端
 * @author liupeqing
 * @date 2019/2/13 19:29
 */
public class ShapeFactory2 {

    public static Object getClass(Class<? extends Shape> clazz){
        Object object = null;
        try{
            object = Class.forName(clazz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
