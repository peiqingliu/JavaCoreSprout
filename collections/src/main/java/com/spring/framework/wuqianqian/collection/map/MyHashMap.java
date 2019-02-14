package com.spring.framework.wuqianqian.collection.map;

import javax.swing.tree.TreeNode;
import java.util.Set;

/**
 * @author liupeqing
 * @date 2019/1/10 19:59
 */
public class MyHashMap<K,V> implements MyMap<K,V> {

    //默认初始化容量
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //默认初始化数组的长度 16

    //最大的容量
    static final int MAXIMUM_CAPACITY = 1 << 30;

    //默认扩容因子，当容量达到目前容量的0.75，则对数组进行扩容
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //空的数组对象，底层的数组
    static final Entry<?,?>[]  EMPTY_TABLE = {};

    //table,进行扩容操作，长度必须2的n次方
    //transient Entry<K,V>[] table = (Entry<K, V>[]) EMPTY_TABLE;

    //以Node<K,V>为元素的数组，也就是上图HashMap的纵向的长链数组，起长度必须为2的n次幂
    //就是hashmap中 存放数据主要数组部分
    //HashMap由链表+数组组成，他的底层结构是一个数组，
    // 而数组的元素是一个单向链表(就是类 Node)。
    // 吃屎是一个长度为16位的数组，
    // 每个数组储存的元素代表的是每一个链表的头结点。
    //他是整个HashMap的组成子元素，是构成HashMap的一砖一瓦：
    transient Node<K,V>[] table;

    //用来表示map键值对的多少
    transient int size;

    //阈值(阈值 = 容量 * 扩容因子)
    int threshold;

    //加载因子实际的大小
    final float loadFactor;

    //HashMap改变的次数
    transient int modCount;



    //默认初始化数组长度为16，扩容因子为0.75
    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    //构造方法，指定了初始容量
    public MyHashMap(int initialCapacity){
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    //构造方法，指定初始容量和负载因子
    public MyHashMap(int initialCapacity,float loadFactor){
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY){ //大于最大容量的时候
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)){  //扩容因子小于0 或者不是float类型的数据
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);  //阈值 = 初始化的容量 * 扩容因子
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null){
            return getForNullKey();
        }
        return null;
    }

    /**
     * get(key)方法时获取key的hash值，计算hash&(n-1)得到在链表数组中的位置first=tab[hash&(n-1)],
     * 先判断first的key是否与参数key相等，不等就遍历后面的链表找到相同的key值返回对应的Value值即可
     * @return
     */
    //返回key为null的值
    private V getForNullKey(){
        if (size == 0){
            return null;
        }
        //遍历节点
        for (Node<K,V> e = table[0]; e != null; e = e.next){
            if (e.key == null){
                return e.value;
            }
        }
        return null;
    }

    /**
     * 只有在put元素的时候，才会初始化数组
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        return null;
    }

    final private V putVal(int hash,K key,V value,boolean onlyIfAbsent,boolean evict){
        Node<K,V>[] tab;  //数组
        Node<K,V> p; //元素
        int n,i;
        if ((tab= table) == null || (n = tab.length) == 0){  //第一步 如果table为空，则调用resize()函数创建一个
            n = (tab = resize()).length;
        }
        if ((p = tab[i = (n - 1) & hash]) == null){  //第二步，计算元素所要储存的位置index,并对null做出处理
            //注意这里，如果tab[i]==null，说明这个位置上没有元素，这个时候就创建一个新的Node元素
            tab[i] = newNode(hash, key, value, null);
        }else{
            //else,否则，也就是，这个要添加的位置上面已经有元素了，也就是发生了碰撞。这个时候就要具体情况
            //分类讨论：1.key值相同，直接覆盖 2.链表已经超过了8位，变成了红黑树 3.链表是正常的链表
            Node<K,V> e; K k;
            if (p.hash == hash &&            //如果节点key存在，则覆盖原来位置的key
                    ((k = p.key) == key || (key != null && key.equals(k)))){
                e = p;

            }else if (p instanceof TreeNode){   //第三步，判断该链是否为红黑树
               // e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }else{

            }
        }

        return p.value;
    }

    /**
     * 创建新的节点
     * @param hash
     * @param key
     * @param value
     * @param next
     * @return
     */
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }

    //HashMap扩容机制的实现
    final Node<K,V>[] resize(){
        Node<K,V>[] oldTable = table;   //创建一个oldTab数组用于保存之前的数组
        int oldCap = (oldTable==null) ? 0 : table.length;  //获取原来数组的长度
        int oldthreshold = threshold;  //原来数组的临界值
        int newCap,newThr = 0;
        if (oldCap > 0){
            if (oldCap > MAXIMUM_CAPACITY){  //如果原来的数组长度大于最大值(2^30)
                threshold = Integer.MAX_VALUE;   //扩容临界值提高到正无穷
                return oldTable;  //返回原来的数组，也就是系统已经管不了了，随便你怎么玩吧
            }
            /**
             * 重点说明：新的数组 = 原来数组的2倍 < 最大值(2^30) && (原来的数组长度) >= 初始长度</>
             * 这个else if 中实际上就是咋判断新数组(此时刚创建还为空)和老数组的长度合法性，同时交代了，
             *  我们扩容是以2^1为单位扩容的。下面的newThr(新数组的扩容临界值)一样，在原有临界值的基础上扩2^1
             */
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap > DEFAULT_INITIAL_CAPACITY){
                newThr = oldthreshold << 1;  //旧的临界值2倍
            }
        }else if (oldthreshold > 0){  //旧数组的临界值大于0
            newCap = oldthreshold;  //新数组的初始容量设置为老数组扩容的临界值
        }else {  //否则 oldThr == 0,零初始阈值表示使用默认值，表明旧的数组没有。
            newCap = DEFAULT_INITIAL_CAPACITY;  //初始化数组
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);  // 扩容大小为数组长度 * 扩容因子
        }
        if (newThr == 0){  //如果newThr == 0,说明上面elseif oldthreshold > 0的情况，(其他两种情况都对newThr的值做了改变),此时newCap = oldThr;
            float ft = newCap * loadFactor; //ft为临时变量，用于判断阈值的合法性
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);     //计算新的阈值

        }

        threshold = newThr; //改变阈值
        Node<K,V>[] newTab = (Node<K, V>[]) new Node[newCap];  //创建一个newCap的大小数组
        table = newTab; //改变table的全局变量，改为扩容的数组。
        if (oldTable != null){
            for (int j=0;j< oldTable.length;j++){  //遍历数组，将老数组(或者原来的桶)迁移到新的数组(新的桶)中
                Node<K,V> e; //新建一个Node<K,V>类对象，用它来遍历整个数组
                if ((e=oldTable[j]) != null){
                    oldTable[j] = null;
                    if (e.next == null){  //没有下一个节点
                        //将e也就是oldTab[j]放入newTab(新数组)中e.hash & (newCap - 1)的位置，
                        newTab[e.hash & (newCap - 1)] = e;
                    }else if(e instanceof TreeNode){ //如果e已经是一个红黑树的元素，这个我们不展开讲
                        //((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    }else {  // 链表重排，这一段是最难理解的，也是ldk1.8做的一系列优化.
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    //静态内部类：Node节点实现Entry接口
    //可以看出Node是HashMap的一个内部类，它既是数组的组成元素，也是链表的组成元素，
    //包含了数组元素所需要的K,V,也包含了指向下一个元素的next。
    static class Node<K,V> implements MyMap.Entry<K,V>{

        final int hash;  //每个储存元素key的哈希值，这个hash值是系统在创建Node时通过一定的算法计算出来的一个int值
        final K key;
        V value;
        Node<K,V> next; //指向下一个节点(单列表)

        Node(int hash, K key,V value,Node<K,V> node) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = node;
        }


        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }
}
