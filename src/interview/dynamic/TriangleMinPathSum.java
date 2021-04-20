package interview.dynamic;

import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:43
 */
public class TriangleMinPathSum {

    /**
     *  给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * 滚动数组的核心是倒序遍历，先抢占一个空余的位置。
     * 问题达到当前规模时的最优解，特征是dp[len]即最优解。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }
        int finLen = triangle.get(triangle.size() - 1).size();
        int dp[] = new int[finLen];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curLevel = triangle.get(i);
            for (int j = curLevel.size() - 1; j >= 0; j--) {
                //等于0或者max只能取到上一层的单个节点
                if (j == 0) {
                    dp[j] = dp[j] + curLevel.get(j);
                } else if (j == curLevel.size() - 1) {
                    dp[j] = dp[j - 1] + curLevel.get(j);
                } //中间节点可以取到上层2个的节点
                else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + curLevel.get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < finLen; i++) {
            res = Math.min(dp[i], res);
        }
        return res;

    }
}
