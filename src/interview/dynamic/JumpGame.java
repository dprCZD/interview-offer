package interview.dynamic;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJumped = 0;
        for(int i =0;i< n;++i){
            maxJumped = Math.max(maxJumped,i+nums[i]);
            if (maxJumped >= n-1){
                return true;
            }else if(maxJumped<=i){
                return false;
            }
        }
        return false;
    }
}