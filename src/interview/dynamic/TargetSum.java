package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:54
 */
public class TargetSum {

    /**
     * 目标和-01背包
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * <p>
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * <p>
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S < -sum || S > sum || (sum + S) % 2 == 1) return 0;

        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] = dp[j - num] + dp[j];
            }
        }
        return dp[target];

    }
}
