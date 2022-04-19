package interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Date: 2021/4/2 19:35
 */
public class SpiralOrderMatrix {
    public static void main(String[] args) {
        int [][]matrix =new int[3][3];
        matrix[0]=new int[]{1,2,3};
        matrix[1]=new int[]{4,5,6};
        matrix[2]=new int[]{7,8,9};


        System.out.println(new SpiralOrderMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res =new ArrayList<>();
        if(matrix ==null||matrix.length==0||matrix[0].length==0){
            return res;
        }
        //四个方向
        int up =0;
        int down =matrix.length-1;
        int left =0;
        int right =matrix[0].length-1;

        //当前指针
        int i=0;int j=0;

        while(up<=down&&left<=right){
            while(j<=right){
                res.add(matrix[i][j++]);
            }
            up++;
            i=up;j=right;
            while(i<=down){
                res.add(matrix[i++][j]);
            }
            right--;
            i=down;j=right;
            //这里要判断当up>down时说明已经到了不对称的节点，只需要走前两步即可。
            while(j>=left&&up<=down){
                res.add(matrix[i][j--]);
            }
            down--;
            i=down;j=left;
            while(i>=up&&left<=right){
                res.add(matrix[i--][j]);
            }
            left++;
            i=up;j=left;

        }


        return res;
    }
}
