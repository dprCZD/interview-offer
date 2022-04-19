package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:38
 */
public class MinPathSum {

    /**
     *
     * @param matrix
     * @return
     */
    public int minPathSum(int[][] matrix) {
        //横累加
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] + matrix[i][0];
        }
        //纵累加
        for (int j = 1; j < matrix[0].length; j++) {
            matrix[0][j] = matrix[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + matrix[i][j];
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
