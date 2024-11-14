package interview.dynamic;

public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = nums[0];
        int pre = 0;
        for(int num:nums){
            pre = Math.max(pre+num,num);
            res = Math.max(pre,res);
        }
        return res;

    }
}
