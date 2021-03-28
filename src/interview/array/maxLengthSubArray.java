package interview.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: czd
 * @Description:
 * 找到字符串的最长无重复子串
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * @Date: 2021/3/20 19:30
 */
public class maxLengthSubArray {


    public int maxLength (int[] arr) {
        // write code here
        int max = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr){
            //如果出现相等的，则移动窗口左侧到相等位置的右侧;
            while(set.contains(num)){
                set.remove(arr[left]);
                left++;
            }
            set.add(num);
            max=Math.max(max,set.size());
        }
        return max;
    }


    /**
     * 该方法通过Map记录每一个数的位置，遇到相同时直接移动左侧窗口，不需要删除元素。
     * @param arr
     * @return
     */
    public int maxLengthPro (int[] arr) {
        // write code here
        int max = 0;
        int left = 0;
        int right =0;
        Map<Integer,Integer> map =new HashMap<>();
        for(int num:arr){
            //如果发现重复则移动左侧窗口
            if(map.containsKey(num)){
                //如果是重复的窗口前元素则不予考虑
                left=Math.max(left,map.get(num)+1);
            }
            map.put(num,right);
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
