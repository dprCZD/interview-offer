package interview.math;


public class productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null){
            return null;
        }
        int n = nums.length;
        if(n == 0 || n ==1)
        {
            return  nums;
        }
        int[] result = new int[n];
        // calculate prefix
        result[0] = nums[0];
        for(int i =1;i<n;i++)
        {
            result[i] = result[i-1] * nums[i];
        }

        // calculate suffix and build result.
        int suffix = nums[n-1];
        result[n-1] = result[n-2];
        for(int i = n-2;i>0;i--)
        {
            result[i] = result[i-1]*suffix;
            suffix = suffix * nums[i];
        }
        result[0] = suffix;
        return result;
    }
}
