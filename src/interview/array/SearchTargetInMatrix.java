package interview.array;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/26 21:12
 */
public class SearchTargetInMatrix {


    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        if (m == 0 || n == 0) {
            return null;
        }
        int i = n - 1;
        int j = 0;
        //> 从左下往右上搜索
        while (i >= 0 && j < m) {
            if (mat[i][j] == x) {
                return new int[]{i, j};
            } else if (mat[i][j] < x) {
                j++;
            } else {
                i--;
            }
        }
        return null;
    }
}
