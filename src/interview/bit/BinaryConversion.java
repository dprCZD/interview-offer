package interview.bit;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/23 23:47
 */
public class BinaryConversion {

    public String solve(int M, int N) {
        // write code here
            boolean flag = false;
            if (M == 0) {
                return "0";
            } else if (M < 0) {
                flag = true;
                M=-M;
            }

            StringBuilder resultBuilder = new StringBuilder();
            char[] nums = "0123456789ABCDEF".toCharArray();

            while(M!=0){
                resultBuilder.append(nums[M%N]);
                M=M/N;
            }

            if(flag){
                resultBuilder.append("-");
            }
            return resultBuilder.reverse().toString();

    }
}
