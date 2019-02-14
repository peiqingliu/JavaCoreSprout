package com.spring.framework.wuqianqian.collection.list;

/**
 * @author liupeqing
 * @date 2019/1/5 16:16
 */
public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        System.out.println(list.get(0));
    }
}
