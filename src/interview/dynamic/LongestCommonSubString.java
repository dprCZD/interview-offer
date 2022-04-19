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
     * 二维的状态记录压缩核心的要点逻辑：
     * 1. 内循环要逆序，否则会刷新掉上一轮的状态。
     * 2. 要初始化好状态，否则会读取到之前的错误状态。
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonSubStringUp(String str1, String str2) {
        //这里+1是因为0为初始状态。
        int[] dp = new int[str2.length() + 1];
        //这里表示最长子串的长度。
        int max = 0;
        //这里表示最长子串开始的位置
        int index = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = str2.length(); j >0; j--) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    //核心的状态方程，如果当前的字符相等，则寻找str1和str2串上一个字符的状态（相等数）。
                    dp[j] = dp[j - 1] + 1;
                    if (max < dp[j]) {
                        max = dp[j];
                        index = i;
                    }
                }else{
                    dp[j]=0;
                }
            }
        }
        return str1.substring(index - max, index);
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
    public String LongestCommonSubSenquence2(String s1, String s2) {

        if(s1==null||s2==null||s1.length()==0||s2.length()==0){
            return "-1";
        }
        //> 计算出最长
       int [][]dp =new int[s1.length()+1][s2.length()+1];
       for(int i=1;i<s1.length()+1;i++){
           for(int j=1;j<s2.length()+1;j++){
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;
               }else {
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
           }
       }

       //> 构造公共子序列
       StringBuilder res =new StringBuilder("");
       int sl1=s1.length();
       int sl2 =s2.length();
       while(sl1>0&&sl2>0){
           if(s1.charAt(sl1-1)==s2.charAt(sl2-1)){
               res.insert(0,s1.charAt(sl1-1));
               sl1--;
               sl2--;
           }else {
               if(dp[sl1-1][sl2]>dp[sl1][sl2-1]){
                   sl1--;
               } else{
                   sl2--;
               }
           }
       }
       if(res.toString().length()==0){
           return "-1";
       }
       return res.toString();
    }
}
