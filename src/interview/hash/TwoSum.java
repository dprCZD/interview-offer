package interview.hash;

import java.util.HashMap;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/1/24 17:13
 */
public class TwoSum {


    public int[] twoSum (int[] numbers, int target) {
        // write code here
        if(numbers==null||numbers.length<1){
            return null;
        }
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }
        for(int i=0;i<numbers.length;i++){
            Integer j=map.get(target-numbers[i]);
            if(j!=null&&i!=j){
                int res[]=new int[2];
                res[0]=i+1;
                res[1]=j+1;
                return res;
            }
        }
        return null;
    }
}
