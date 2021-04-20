package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:36
 */
public class LongestUpSubSenquence {
    /**
     * 最长上升子序列
     * 动态规划
     * 核心是以当前的节点为锚，找之前小于当前节点的最长序列+1。初始状态为1。
     * 状态转移方程：dp[i]=dp[j]+1;
     * 包含当前状态的最优解，特征是dp数组内的最大值为最终最优解。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
