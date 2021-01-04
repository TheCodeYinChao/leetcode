package cn.leetcode.secondary;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU是Least Recently Used的缩写，即最近最少使用，是一种常用的页面置换算法，选择最近最久未使用的数据予以淘汰
 * 该算法赋予每个页面一个访问字段，用来记录一个页面自上次被访问以来所经历的时间t，当须淘汰一个页面时，选择现有页面中其t值最大的，即最近最少使用的页面予以淘汰
 * <p>
 * 分析：
 * LRU算法的核心是哈希链表 （哈希表 + 双向链表  查找、插入、删除都快）
 * JDK中对LinkedHashMap的说明就是 非常适合用于构建LRU Caches
 * <p>
 * 场景：
 * Redis内存淘汰策略就采用LRU
 * <p>
 * 来源：
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/04  16:23
 **/
public class LRUCache<K, V> extends LinkedHashMap<K, V> { // 依赖JDK
    private int capacity;   // 容量

    public LRUCache(int capacity) {
        /**
         * accessOrder      the ordering mode
         *  <tt>true</tt> for access-order, 通过访问顺序
         *  <tt>false</tt> for insertion-order 通过插入顺序
         */
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        return super.size() > capacity;
    }

//    public int get(int key) {
//
//        return -1;
//    }
//
//    public void put(int key, int value) {
//
//    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.keySet());
        lruCache.put(4,4);

        System.out.println(lruCache.keySet());
        lruCache.put(3,3);
        System.out.println(lruCache.keySet());

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.keySet());
    }
}
