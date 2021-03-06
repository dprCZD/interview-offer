package interview;

import java.util.*;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/10/18 20:31
 */
public class LRUCache {

    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;
    private int len;
    private int curLen = 0;


    public LRUCache(int len) {
        map = new HashMap<>(len);
        list = new LinkedList<>();
        this.len = len;

    }

    public void set(Integer key, Integer value) {
        //没有达到最大值，直接put
        if (curLen < len) {
            map.put(key, value);
            list.addFirst(key);
            curLen++;
        } else {
            //到达最大值,执行删除
            Integer del = list.removeLast();
            map.remove(del);
            //删除尾节点后头插
            map.put(key, value);
            list.addFirst(key);
        }

    }

    public Integer get(Integer key) {
        Integer value = map.get(key);
        if(value==null){
            return -1;
        }
        Iterator it = list.listIterator();
        while (it.hasNext()) {
            Integer listVal = (Integer) it.next();
            if (listVal.equals(key)) {
                it.remove();
                break;
            }
        }
        list.addFirst(key);
        return value;
    }

    public static  int[] LRU(int[][] operators, int k) {
        List<Integer> resList = new ArrayList<>();
        LRUCache cache = new LRUCache(k);
        for (int[] subArray : operators) {
            if (subArray[0] == 1) {
                cache.set(subArray[1], subArray[2]);
            } else if (subArray[0] == 2) {
                resList.add(cache.get(subArray[1]));
            }
        }
        int res[] = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;

        // write code here
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int data[][]=new int[6][3];
        for(int i=0;i<6;i++){
            data[i][0]=sc.nextInt();
            data[i][1]=sc.nextInt();
            data[i][2]=sc.nextInt();
        }
        int k=sc.nextInt();
        LRUCache.LRU(data,k);


    }
}
