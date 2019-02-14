package com.spring.framework.wuqianqian.collection.map;

import java.util.Set;

/**
 * 底层实现是数组+链表
 * @author liupeqing
 * @date 2019/1/5 17:23
 */
public interface MyMap<K,V> {

    //返回map中key-value映射的数量
    int size();

    //如果map中没有key-value映射返回true
    boolean isEmpty();

    //是否包含指定的key
    //如果map不含key映射，返回false，当key的类型不符合，抛出ClassCastException，
    //当key是null且该map不支持key的值是null时，抛出NullPointerException
    boolean containsKey(Object key);

    //同上
    boolean containsValue(Object value);

    //根据key得到对应的value，如果没有对应的映射，返回null，如果map允许value为null，返回null
    //可能是有一对key-null的映射或没有对应的映射
    V get(Object key);

    //往map放入一对key-value映射
    V put(K key, V value);

    //根据key删除对应映射
    V remove(Object key);

    //清空map中所有的映射
    void clear();

    //返回map中所有key的集合
    Set<K> keySet();


    /**
     * Map接口里有一个内部接口Entry<K,V>，其实它就是Map存放key-value映射的数据结构
     * @param <K>
     * @param <V>
     */
    interface Entry<K,V>{

        K getKey();

        V getValue();

    }
}
