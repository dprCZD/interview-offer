package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/3/22 22:38
 */
public class findPeakElement {

    /**
     * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
     * @param nums
     * @return
     */
    public int findPeakElement (int[] nums) {
        // write code here
        int left =0;
        int right =nums.length-1;
        //关键思想：下坡的时候可能找到波峰，但是可能找不到，一直向下走的
        //上坡的时候一定能找到波峰，因为题目给出的是nums[-1] = nums[n] = -∞
        while(left<right){
            int mid =(left+right)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
