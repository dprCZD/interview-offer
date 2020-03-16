package easy;

public class No04 {

    /**
     * 从右上角T（从左向右最大，从上到下最小的点）开始搜索：
     * 如果target>T，则说明本行均比它小，T向下滑动；
     * 如果target<T，则向左滑动
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int i=0;
        int j=matrix[0].length-1;
        while(j>=0&&i<n){
            if (matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                i++;
            }else{
                j--;
            }
        }
        return false;

    }
}
