package interview.dynamic;

/**
 * @Author: czd
 * @Description: 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 解法：
 * 可以使用动态规划降低时间复杂度。我们用 dp(i,j) 表示以(i,j) 为右下角，且只包含 11 的正方形的边长最大值。
 * 如果我们能计算出所有 dp(i,j) 的值，那么其中的最大值即为矩阵中只包含 1 的正方形的边长最大值，其平方即为最大正方形的面积。
 *

 * 那么如何计算 dp 中的每个元素值呢？对于每个位置 (i, j)，检查在矩阵中该位置的值：
 *
 * 如果该位置的值是 0，则 dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中；
 *
 * 如果该位置的值是 1，则 )dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的} 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
 *
 * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
 *

 * @Date: 2021/4/4 22:16
 */
public class MaxSquare {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //动态规划数组
        int[][] dp = new int[matrix.length][matrix[0].length];

        //最大边长值
        int maxSide = 0;

        //赋予初始值
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '0'?0:1;
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i]== '0'?0:1;
            maxSide = Math.max(maxSide, dp[0][i]);

        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                //状态转移方程
                dp[i][j]= min(dp[i - 1][j], dp[i - 1][j - 1] ,dp[i][j - 1])+1;
                //比较最大边长
                maxSide = Math.max(dp[i][j], maxSide);
            }
        }
        return maxSide * maxSide;


    }
    int min(int a,int b,int c){
       if(a<=b){
           if(a<=c){
               return a;
           } else{
               return c;
           }
       } else {
           if(c<=b){
               return c;
           } else {
               return b;
           }
       }
    }

}
