package interview.array;

/**
 * @Author: czd
 * @Description: 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 * 主要思想就是，如果找最小未出现的正整数，必然在1~n+1中，所以对于所有a[i]，如果a[i]在[1,n]中，那么就放到这个位置上去，否则大于n或者小于1的话，就不管它
 * @Date: 2022/4/3 23:10
 */
public class MinNumberDisappeared {

    public int minNumberDisappeared(int[] nums) {
        // write code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            //> 这里要做while循环，将该数相关全部归位。
            while (nums[i] <= nums.length && nums[i] > 0&&nums[i]!=i+1) {
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
