package interview.hash;

import java.lang.reflect.Array;
import java.util.*;

class RandomizedSet {

    private Map<Integer,Integer> map;
    private ArrayList<Integer> list;
    private Random random;
    private int size = 0;



    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,size);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int lastVal = list.get(size-1);
            // Move the last value to current index;
            list.set(index, lastVal);
            map.put(lastVal, index);
            // remove the value
            list.remove(size-1);
            map.remove(val);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}
public class RandomSet {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        System.out.println(set.getRandom());
    }
}
