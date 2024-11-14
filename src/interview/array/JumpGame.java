package interview.array;

/**
 * @Author: czd
 * @Description:
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 * @Date: 2022/5/10 23:08
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        for(int i = 1;i<nums.length;i++){
            if(nums[i-1]<i){
                return false;
            }
            nums[i]=Math.max(nums[i-1],i+nums[i]);
        }
        return true;

    }
}
