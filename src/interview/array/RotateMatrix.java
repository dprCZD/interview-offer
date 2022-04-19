package interview.array;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/19 16:28
 */
public class RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        //> 将行列转置
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                int temp =mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //> 将列的首尾互换
        for(int i =0;i<n/2;i++){
            for(int j =0;j<n;j++){
                int temp =mat[j][i];
                mat[j][i]= mat[j][n-i-1];
                mat[j][n-i-1]=temp;
            }
        }
        return mat;

    }

    private void swap(int[][] mat, int i,int j ){
        int temp =mat[i][j];
        mat[i][j]=mat[j][i];
        mat[j][i]=temp;
    }
}
