package com.spring.framework.wuqianqian.collection.list;

/**
 * 静态类
 * @author liupeqing
 * @date 2019/1/5 14:12
 */
public abstract class MyAbstractList<E> implements MyList<E>{

    protected int size = 0;

    /**
     * 修改的次数
     */
    protected transient int modCount = 0;

    protected MyAbstractList(){}

    protected MyAbstractList(E[] elements){
       for (int i=0;i<elements.length;i++){
           add(elements[i]);
       }
    }

    public void add(E e){
        add(size,e);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean romve(E e) {
        if (indexOf(e) >= 0){
            romve(indexOf(e));
            return true;
        }
        return false;
    }
}
