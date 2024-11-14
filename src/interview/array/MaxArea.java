package interview.array;

/**
 * @Author: czd
 * @Description: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * @Date: 2022/4/30 21:09
 */
public class MaxArea {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.min(height[left], height[right]) * (right - left);
        }
        return max;

    }
}
