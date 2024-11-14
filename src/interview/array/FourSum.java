package interview.array;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer,Integer> map12 = new HashMap<>();
        for(int n1 : nums1){
            for(int n2: nums2)
            {
                map12.put(n1+n2,map12.getOrDefault(n1+n2,0)+1);
            }
        }
        for(int n3:nums3){
            for(int n4:nums4){
                res+= map12.getOrDefault(-n3-n4,0);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
