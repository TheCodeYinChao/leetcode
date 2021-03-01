package cn.leetcode.secondary;

import java.util.HashMap;
import java.util.Map;

//import java.util.LinkedHashMap;
//import java.util.Map.Entry;

/**
 * 不采用LinkedHashMap
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/04  17:45
 **/
public class LRUCacheNotJDK {

//    private int capacity;   // 容量
//    private LinkedHashMap<Integer,Integer> map;
//
//    public LRUCacheNotJDK(int capacity) {
//        /**
//         * accessOrder      the ordering mode
//         *  <tt>true</tt> for access-order, 通过访问顺序
//         *  <tt>false</tt> for insertion-order 通过插入顺序
//         */
//        this.map = new LinkedHashMap(capacity,0.75F,true){
//
//            protected boolean removeEldestEntry(Entry eldest) {
//                return super.size() > capacity;
//            }
//        };
//        this.capacity = capacity;
//    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            head.next = tail;
            head.prev = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        public Node getLast() {
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheNotJDK(int capacity) {
        this.cacheSize = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        Node<Integer, Integer> node = map.get(key);
        if (node != null) {
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
            return node.value;
        }
        return -1;

    }

    public void put(int key, int value) {

        Node<Integer, Integer> node = map.get(key);
        if (node != null) {
            node.value = value;
            map.put(key,node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if (map.size() == cacheSize){
                Node last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }

            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

}