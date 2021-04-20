package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:30
 */
public class LongestCommonSubString {


    /**
     * 最长公共子串
     * 动态规划
     * 核心是保存状态，利用上一次的状态计算这次的结果。
     * 问题达到当前规模时的最优解，特征是dp[len]即最优解。
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonSubString(String str1, String str2) {
        //这里+1是因为0为初始状态。
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        //这里表示最长子串的长度。
        int max = 0;
        //这里表示最长子串开始的位置
        int index = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    //核心的状态方程，如果当前的字符相等，则寻找str1和str2串上一个字符的状态（相等数）。
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        String res = str1.substring(index - max, index);
        if (res.isEmpty()) {
            return "-1";
        }
        return res;
        // write code here
    }

    /**
     * 最长子序列
     * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则输出-1。
     * 动态规划
     * 相对于最长公共字串来说，它在两个字符不相等时，也需要对上次的状态做处理，核心思想是转换为子串的处理。
     * 问题达到当前规模时的最优解，特征是dp[len]即最优解。
     * @param str1
     * @param str2
     * @return
     */
    public int LongestCommonSubSenquence(String str1, String str2) {
        //这里+1是因为0为初始状态。
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];

    }
}
