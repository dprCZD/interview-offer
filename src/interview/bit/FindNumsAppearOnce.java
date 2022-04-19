package interview.bit;

/**
 * @Author: czd
 * @Description:一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @Date: 2022/3/27 23:11
 */
public class FindNumsAppearOnce {
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        //>所有数进行异或。
        int temp = 0;
        for (int num : array) {
            temp ^= num;
        }

        //> 根据异或结果找出分组key
        int mask = 1;
        while ((temp & mask) == 0) {
            mask <<= 1;
        }

        //> 根据分组key进行分组
        int a = 0;
        int b = 0;
        for (int num : array) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        System.out.println(a+":"+b);
        return a > b ? new int[]{b, a} : new int[]{a, b};
    }
}
