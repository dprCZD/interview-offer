package interview.bit;

/**
 * @Author: czd
 * @Description: 给定一个长度为 n 的整型数组 arr 和一个整数 k(k>1) 。
 * 已知 arr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 * @Date: 2022/1/22 21:37
 */
public class FindOnceNumber {
    /**
     * 核心思路：将数组的每一位二进制相加，再找出不为0的位还原即可。
     *现k(奇数)次的数字每个位（0或者1）也是出现k(奇数)次，因此可以每一位的和能够被k整除（对k取余为0）。
     * 所以如果把每个数的二进制表示的每一位加起来，对于每一位的和，如果能被k整除，那对应那个只出现一次的数字的那一位就是0，否则对应的那一位是1。
     * @param arr
     * @param k
     * @return
     */
    public int foundOnceNumber(int[] arr, int k) {
        int []bits = new int[32];
        for (int i = 0; i < 32; i++) {
            //计算每一位的和
            int sum = 0;
            for (int num : arr) {
                sum += (num >> i & 1);
            }
            bits[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //左移还原数字
            if (bits[i] % k != 0) {
                res += 1 << i;
            }
        }
        return res;
    }
}
