package interview.dynamic;

/**
 * @Author: czd
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Date: 2021/4/10 20:17
 */
public class ReceiveRain {
    /**
     * 对于下标 ii，下雨后水能到达的最大高度等于下标 ii 两边的最大高度的最小值，下标 ii 处能接的雨水量等于下标 ii 处的水能到达的最大高度减去 height[i]。
     *
     * 朴素的做法是对于数组 height 中的每个元素，分别向左和向右扫描并记录左边和右边的最大高度，然后计算每个下标位置能接的雨水量。假设数组 height 的长度为 n，该做法需要对每个下标位置使用 O(n)的时间向两边扫描并得到最大高度，因此总时间复杂度是 O(n^2)
     *
     * 上述做法的时间复杂度较高是因为需要对每个下标位置都向两边扫描。如果已经知道每个位置两边的最大高度，则可以在 O(n)的时间内得到能接的雨水总量。使用动态规划的方法，可以在 O(n)的时间内预处理得到每个位置两边的最大高度。
     *
     * 创建两个长度为 nn 的数组 leftMax 和 rightMax。对于 0≤i<n，leftMax[i] 表示下标 i 及其左边的位置中，height 的最大高度，rightMax[i] 表示下标 i及其右边的位置中，height 的最大高度。
     *
     * 显然，leftMax[0]=height[0]，rightMax[n−1]=height[n−1]。两个数组的其余元素的计算如下：
     *
     * 当 1 ≤i≤n−1 时leftMax[i]=max(leftMax[i−1],height[i])；
     *
     * 当 0≤i≤n−2 时，rightMax[i]=max(rightMax[i+1],height[i])。
     *
     * 因此可以正向遍历数组 height 得到数组 leftMax 的每个元素值，反向遍历数组 height 得到数组 rightMax 的每个元素值。
     *
     * 在得到数组 leftMax 和 rightMax 的每个元素值之后，对于 0≤i<n，下标 ii 处能接的雨水量等于 min(leftMax[i],rightMax[i])−height[i]。遍历每个下标位置即可得到能接的雨水总量。
     *

     * @param height
     * @return
     */

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        final int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        //初始化左侧最大值和右侧最大值
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += cur > 0 ? cur : 0;
        }

        return  res;
    }
}
