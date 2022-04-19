package interview;

import java.util.*;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/10/18 20:31
 */
public class LRUCache {

    private int capacity = 16;
    private int size = 0;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        // write code here
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public LRUCache() {
        // write code here
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }


    public int get(int key) {
        // write code here
        if(size == 0){
            return -1;
        }
        Node node = cache.get(key);
        if(node!=null){
            addHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        // write code here
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
        } else {
            if (size >= capacity) {
                cache.remove(removeTail().key);
            }
            node = new Node(key, value);
            cache.put(key, node);
        }
        addHead(node);
        size++;
    }

    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    private void addHead(Node node) {
        //> 如果是已存在的元素，则将其原位置删除。
        if (node.pre != null && node.next != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.pre = head;
        temp.pre = node;
    }

    private Node removeTail() {
        Node removed =tail.pre;
        Node temp = tail.pre.pre;
        tail.pre = temp;
        temp.next = tail;
        removed.pre=null;
        removed.next=null;
        return removed;
    }

    public static void main(String[] args) {
        LRUCache LRUCache = new LRUCache(2);
        LRUCache.set(1,1);
        LRUCache.set(2,2);
        LRUCache.get(1);
        LRUCache.set(3,3);
        LRUCache.get(2);
        LRUCache.set(4,4);
        LRUCache.get(1);
        LRUCache.get(3);
        LRUCache.get(4);




    }


}
