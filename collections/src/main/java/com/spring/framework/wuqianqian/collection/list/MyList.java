package com.spring.framework.wuqianqian.collection.list;

/**
 * Java集合类的基本接口是Collection接口。而Collection接口必须继承java.lang.Iterable接口。
 * @author liupeqing
 * @date 2019/1/5 13:58
 */
public interface MyList<E> extends Iterable {

    //增加元素
    public void add(E e);

    //在指定位置添加
    public void add(int index,E e);

    //清除
    public void clear();

    //是否包含元素
    public boolean contains(E e);

    //根据index 获取元素
    public E get(int index);

    //元素e的位置
    public int indexOf(E e);

    //是否为空
    public boolean isEmpty();

    //删除元素
    public boolean romve(E e);

    //根据index删除元素，并返回删除元素的值
    public E romve(int index);

    //list的长度
    public int size();

    //替换指定位置上的元素
    public E set(int index,E e);

    public void show();
}
