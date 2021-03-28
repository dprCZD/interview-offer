package interview.dynamic;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * @Author: czd
 * @Description:
 * @Date: 2021/1/31 20:20
 */
public class MaxsumofSubarray {

    public int maxsumofSubarray (int[] arr) {
        int max=arr[0];
        int sum=0;
        // write code here
        for(int i=0;i<arr.length;i++){
            //如果到现在为止的总和>0说明当前总和是有用的。否则总和是无用的应该删去。
            if(sum>0){
                sum+=arr[i];
            } else {
                sum=arr[i];
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
