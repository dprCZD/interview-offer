package interview.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: czd
 * @Description: 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * @Date: 2021/4/2 18:17
 */
public class MatrixkthSmallest {
    //方案1 直接用小根堆，时间复杂度n2logk
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        //大根堆
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                } else if (queue.peek() > matrix[i][j]) {
                    queue.poll();
                    queue.offer(matrix[i][j]);
                }
            }
        }
        return queue.peek();

    }

    /**
     * 核心思路：统计小于mid的数，当小于mid的数=k时返回。由于矩阵的特性，mid左上角的数一定小于mid。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallestbetter(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //如果<=mid的数大于等于k，则缩小上边界
            if (check(mid, matrix, k)) {
                right = mid;
            }
            //否则上升下边界
            else {
                left = mid + 1;
            }
        }
        //在最后逼近后会出现right/left交换或相等的情况，此时由于left上升的条件是<k,当left和right交错时，left必=k。
        return left;


    }

    private boolean check(int mid, int[][] matrix, int k) {
        int i = matrix.length - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < matrix.length) {
            //从左下角开始统计，如果当前的数>mid，向上移动，否则统计当前行数，向右移动。
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        //返回<=mid的数是否大于等于k。
        return num >= k;
    }

}
