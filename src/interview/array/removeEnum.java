package interview.array;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/8/12 0:07
 */
public class removeEnum {


    public static  int removeDuplicates(int[] nums) {
        int len =nums.length;
        for( int i= 0;i<len;i++){
            int j =i+1;
            while(j<len&&nums[i] == nums[j]){
                j++;
            }
            int x =j-i-1;
            for(;j<len;j++){
                nums[j-x] =nums[j];
            }
            len-=x;
        }
        return len;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
