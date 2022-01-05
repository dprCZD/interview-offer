package interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/5/12 13:27
 */
public class LFUCache {

    int minFreq;

    int capacity;

    Map<String, Node> keyMap;

    Map<Integer, LinkedList<Node>> freqMap;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public Object get(String key) {
        if (capacity == 0) {
            return null;
        }
        if (!keyMap.containsKey(key)) {
            return null;
        }
        Node node = keyMap.get(key);
        if (node == null) {
            return null;
        }
        Object val = node.getValue();
        int freq =node.getFreq();
        freqMap.get(freq).remove(node);
        //当前链表为空时进行删除链表，
        if(freqMap.get(freq).size() == 0){
            freqMap.remove(freq);
            if(minFreq == freq){
                minFreq+=1;
            }
        }
        LinkedList<Node> list = freqMap.getOrDefault(freq+1,new LinkedList<>());
        Node newNode = new Node(key,val,freq+1);
        list.offerFirst(newNode);
        freqMap.put(freq+1,list);
        keyMap.put(key,newNode);
        return val;
    }


    public void put(String key, Object value) {
        if(capacity == 0){
            return;
        }
        //判断是否在缓存内
        if(!keyMap.containsKey(key)){
            if(keyMap.size()==capacity){
                //缓存满了，移除keyMap和freqMap中的minFreq数据
                Node node = freqMap.get(minFreq).peekLast();
                keyMap.remove(node.getKey());
                freqMap.get(minFreq).pollLast();
                if(freqMap.get(minFreq).size() == 0){
                    freqMap.remove(minFreq);
                }
            }

            LinkedList<Node> list =freqMap.getOrDefault(1, new LinkedList<>());
            Node newNode = new Node(key,value,1);
            list.offerFirst(newNode);
            freqMap.put(1,list);
            keyMap.put(key,newNode);
            minFreq = 1;
        } else {
            Node node = keyMap.get(key);
            int freq = node.getFreq();
            freqMap.get(freq).remove(node);
            if(freqMap.get(freq).size() == 0){
                freqMap.remove(freq);
                if(minFreq == freq){
                    minFreq+=1;
                }
            }
            LinkedList<Node> list = freqMap.getOrDefault(freq+1,new LinkedList<>());
            Node newNode = new Node(key,value,freq+1);
            list.offerFirst(newNode);
            freqMap.put(freq+1,list);
            keyMap.put(key,newNode);
        }

    }


    class Node {
        private String key;
        private Object value;
        private int freq;

        public Node(String key, Object value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache =new LFUCache(2);
        lfuCache.put("2","2");
        lfuCache.put("2","3");
        lfuCache.put("1","5");
        System.out.println(lfuCache.get("2"));
        System.out.println(lfuCache.get("1"));
        lfuCache.put("3","7");
        System.out.println(lfuCache.get("3"));
        System.out.println(lfuCache.get("2"));
        System.out.println(lfuCache.get("1"));


    }
}
