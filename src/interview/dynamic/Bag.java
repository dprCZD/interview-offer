package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:50
 */
public class Bag {

    /**
     * 01背包滚动优化后的结果，核心的逻辑可以参考三角的滚动优化。逆序使得本次调用时dp[j-v[i-1]]还是上一轮i-1的结果。
     *
     * @param v 物品重量
     * @param w 物品价值
     * @param M 物品总数
     * @return
     */
    public static int Bag01(int[] v, int[] w, int M) {
        int[] dp = new int[M + 1];
        for (int i = 1; i <= v.length; i++) {
            for (int j = M; j >= v[i - 1]; j--) {
                if (j >= v[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i - 1]] + w[i - 1]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[M];
    }

    /**
     * 多重背包滚动优化后的结果，核心的逻辑可以参考三角的滚动优化。
     *
     * @param v
     * @param w
     * @param M
     * @return
     */
    public static int allBag(int[] v, int[] w, int M) {
        int[] dp = new int[M + 1];
        for (int i = 1; i <= v.length; i++) {
            for (int j = v[i - 1]; j <= M; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i - 1]] + w[i - 1]);
            }
        }
        return dp[M];
    }

}
