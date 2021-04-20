package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:53
 */
public class PartitionEqualsSub {

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        //获取目标和
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 == 1) {
            return false;
        }
        target = target / 2;

        //动态规划过程
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i - 1]]);
            }
        }

        return dp[target] == 1;

    }

}
