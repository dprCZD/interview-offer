package interview.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/20 22:36
 */
public class LongestUpSubSenquence {
    /**
     * 最长上升子序列
     * 动态规划
     * 核心是以当前的节点为锚，找之前小于当前节点的最长序列+1。初始状态为1。
     * 状态转移方程：dp[i]=dp[j]+1;
     * 包含当前状态的最优解，特征是dp数组内的最大值为最终最优解。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 给定数组 arr ，设长度为 n ，输出 arr 的最长上升子序列。（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
     * <p>
     * 动态规划法，时间复杂度位n2，空间复杂度n。
     *
     * @param arr
     * @return
     */
    public static int[] LIS(int[] arr) {
        // write code here
        int[] dp = new int[arr.length];
        int maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            //> 每个数组最短上升子序列也应该为1，即它本身。
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(dp[i], maxLen);
                }

            }
        }

        int[] res = new int[maxLen];
        //> 倒序遍历DP,依次找到max,max-1对应的第一个数即字典序最小排列。
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == maxLen) {
                res[--maxLen] = arr[i];
            }
        }
        return res;
    }


    /**
     * 贪心算法+二分检索
     *
     * @param arr
     * @return
     */
    public static int[] LIS2(int[] arr) {
        // write code here
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int []lis = new int[arr.length];
        int [] lenArr = new int[arr.length];// 表示以当前下标i为尾巴的最长上升子序列。
        //>
        lis[0]=arr[0];
        lenArr[0]=1;
        int len =1;

        //>
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>lis[len-1]){
                lis[len++]=arr[i];
                lenArr[i]=len;
            }else{
                //> 二分查找替换第一个比当前值大的数
                int left =0;
                int right =len;
                while(left<right){
                    int mid =(left+right)/2;
                    if(lis[mid]<arr[i]){
                        left=mid+1;
                    } else{
                        right=mid;
                    }
                }
                lis[left]=arr[i];
                lenArr[i]=left+1;
            }
        }
        int[] res = new int[len];
        //> 倒序遍历lenArr,依次找到max,max-1对应的第一个数即字典序最小排列。
        for (int i = lenArr.length - 1; i >= 0; i--) {
            if (lenArr[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] lis = LIS2(data);
        for (int num : lis) {
            System.out.println(num);
        }

    }
}
