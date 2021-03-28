package interview.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: czd
 * @Description: 快速排序
 *
 * 所以最理想的时间复杂度为O(nlogn)O(nlogn)。可以证明平均时间复杂度也为O(nlogn)，
 * 最坏的情况下它可以被看做冒泡排序，时间复杂度为O(n2)。
 * 空间复杂度是递归过程中的需要占据的空间，最优情况下空间复杂度为O(nlogn)，很明显它是不稳定的。
 * @Date: 2020/12/27 20:32
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = {1,3,5,2,2};
        System.out.println(maxK(array,5,3));

    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(array, start, end);
        System.out.println(Arrays.toString(array));
        quickSort(array, start, mid - 1);
        quickSort(array, mid + 1, end);

    }

    private static int partition(int[] array, int start, int end) {
        int stage = array[start];
        //这里千万别设置为start+1，会产生很复杂的情况。比如：
        // 由于存在start和end相差1的情况，此时i==j;此时外层while循环必须设置为<=，当在逆序时产生i==j发生死循环。
        int i = start;
        int j = end;
        while (i < j) {
            //跳过start节点不参与比较。
            i++;
            while (i < end && array[i] <= stage) i++;
            while (j > start && array[j] > stage) j--;
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[start] = array[j];
        array[j] = stage;
        return j;
    }

    /**
     * 第k大的数不是第k小的数，要么逆序，要么n-k。
     * @param array
     * @param n
     * @param k
     * @return
     */
    private static int maxK(int[]array ,int n,int k){
        return subMaxK(array,k,0,n-1);
    }

    private static int subMaxK(int[]array,int k,int start,int end){
        int j=partition(array,start,end);
        if(j==(array.length-k)){
            return array[j];
        } else if(j>(array.length-k)){
            return subMaxK(array,k,start,j-1);
        }else{
            return subMaxK(array,k,j+1,end);
        }
    }
}
