package com.spring.framework.wuqianqian.collection.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author liupeqing
 * @date 2019/1/5 14:23
 */
public class MyArrayList<E> extends MyAbstractList<E> {

    /*
    这里用transient修饰数组，用transient关键字标记的成员变量不参与序列化过程。
    serialization（序列化）提供了一种持久化对象实例的机制，通过序列化可以把对象输出到文档中保存。
    而不想某个对象参与序列化，就可以用transient把该对象排除在外。
    */
    //底层的泛型数组用来保存元素
    private transient Object[] elements;

    // 一个空数组对象  被共享
    private static final Object[] EMPTY_ELEMENTDATA = new Object[0];

    // 一个空对象，被共享，如果使用默认构造函数创建，则默认对象内容默认是该值
    //其与EMPTY_ELEMENTDATA的区别是：当我们向数组中添加第一个元素时，知道数组该扩充多少。
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];

    //默认容量
    private static int DEFAULT_CAPACITY = 10;

    // ArrayList的大小（指其所含的元素个数）
    private int size;

    // 数组最大长度
    private static final int MAX_ARRAY_SIZE = 2147483639;

    //实现三个构造方法
    public MyArrayList(){
        //初始化的时候，有效元素个数为0
        this.elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        this.size = 0;
    }

    //自定义初始化大小
    public MyArrayList(int n){
        if (n > 0){
            this.elements =  new Object[n];
            this.size=0;
        }else if( n == 0){
            this.elements = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+n);
        }
    }

    //将其他集合转换成Arraylist
    public MyArrayList(Collection<? extends E> c){
        elements = c.toArray(); //转换成数组，数组容量为集合元素个数
        if ((size = elements.length) != 0){  //此时数组元素个数等于数组容量
            // c.toArray()可能不会正确地返回一个 Object[]数组，那么使用Arrays.copyOf()方法
            if (elements.getClass() != Object[].class){
                //Arrays.copyOf()返回一个 Object[].class类型的，大小为size，元素为elementData[0,...,size-1]
                elements =  Arrays.copyOf(elements, size, Object[].class);
            }else{
                this.elements = EMPTY_ELEMENTDATA;
            }
        }
    }
    //确保添加的元素有地方存储，当第一次添加元素的时候this.size+1 的值是1，所以第一次添加的时候会将当前elements数组的长度变为10：
    private void ensureCapacityInternal(int minCapacity){
        if (elements == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    /**
     * 明确是否需要扩容
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity){
        modCount++;  //记录修改的次数
        //判断是否扩容
        if(minCapacity - elements.length > 0){
            grow(minCapacity);
        }
    }

    /**
     * 扩容方法
     * 增加数组的容量，确保它至少能容纳指定的最小容量的元素量
     * @param n
     */
    private void grow(int n){
        int oldCapacity = elements.length;
        //注意此处扩充capacity的方式是将其向右一位再加上原来的数，实际上是扩充了1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - n < 0){
            newCapacity = n;  //扩容的数量还不能容纳 添加元素的数量，就将添加进来元素的数量作为扩容值
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(n); //设置数组可被分配的最大容量 inteher的最大值
        }
        //把之前的数组复制，newCapacity表示复制的大小，不够的元素为null
        elements = Arrays.copyOf(elements,newCapacity);
        //以上就实现了数组扩容
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    //判断是否超出数组下标
    private void rangeCheck(int index){
        if (index > size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }


    public void add( E e) {
        //添加元素的时候，首先判断容量是不是够
        ensureCapacityInternal(size + 1);
        elements[size++] = e;
    }

    public void add(int index, E e) {

    }

    public void clear() {

    }

    public boolean contains(E e) {
        return false;
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    public int indexOf(E e) {
        return 0;
    }

    public E romve(int index) {
        return null;
    }

    public E set(int index, E e) {
        return null;
    }

    public void show() {

    }

    public Iterator iterator() {
        return null;
    }
}
