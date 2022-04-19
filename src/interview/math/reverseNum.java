package interview.math;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/21 23:14
 */
public class reverseNum {

    public int reverse(int x) {
        // write code here
        int res = 0;
        while (x != 0) {
            int add = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10) && add > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10) && add < -8) {
                return 0;
            }
            res = res * 10 +add;
            x = x / 10;
        }
        return  res;
    }
}
