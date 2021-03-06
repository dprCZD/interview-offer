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
        int max=Integer.MIN_VALUE;
        int cur=0;
        // write code here
        for(int i=1;i<arr.length;i++){
            cur+=arr[i];
            max=Math.max(cur,max);
            //如果当前和<0则减去这一段。
            cur=cur<0?0:cur;
        }
        return max;
    }
}
