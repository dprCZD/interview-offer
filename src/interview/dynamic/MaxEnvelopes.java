package interview.dynamic;

import java.util.Arrays;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:45
 */
public class MaxEnvelopes {

    /**
     * 套娃信封
     * 线性dp的缓存数据代表的含义：
     * 包含当前状态的最优解，特征是dp数组内的最大值为最终最优解。
     * LIS（最长子序列）是指包含当前状态时的最优解；LCS是问题到达当前规模时的最优解。
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int res = 1;
        sort(envelopes, 0, envelopes.length - 1);
        int dp[] = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static void sort(int[][] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(data, left, right);
        sort(data, left, mid - 1);
        sort(data, mid + 1, right);
    }

    private static int partition(int[][] data, int left, int right) {
        int target = data[left][0];
        int i = left;
        int j = right;
        while (i < j) {
            while (i <= right && target >= data[i][0]) {
                i++;
            }
            while (j > left && target < data[j][0]) {
                j--;
            }
            if (i < j) {
                int[] temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int[] temp = data[left];
        data[left] = data[j];
        data[j] = temp;
        return j;

    }
}
