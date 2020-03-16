package easy;


public class No03 {

    public static int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            //如果下标和值相等则跳过
           if(nums[i]==i){
               continue;
           }
           //记录等于当前值的下标的值
           int temp=nums[nums[i]];
           //如果temp与当前值相同，则说明重复，返回
           if(temp==nums[i]){
               return temp;
           }
           //否则将当前值归位到与当前值相同的下标下。
           nums[nums[i]]=nums[i];
           nums[i]=temp;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums={2, 3, 1, 0,2, 5};
        System.out.println(findRepeatNumber(nums));
    }
}
