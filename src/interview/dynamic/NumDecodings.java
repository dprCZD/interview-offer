package interview.dynamic;

/**
 * @Author: czd
 * @Description: 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 解法：
 *
 * @Date: 2021/4/4 21:13
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] strs = s.toCharArray();
        if (strs[0] == '0') {
            return 0;
        }
        int dp1 = 1;//初始dp[-1]
        int dp2 = 1;//初始dp[0]
        int res = 1;
        for (int i = 1; i < strs.length; i++) {
            char cur = strs[i];
            char pre = strs[i - 1];
            int sum = (pre - '0') * 10 + cur - '0';

            //如果当前值为0，则有2种情况：前面的值不为1/2，解码失败返回0；前面的值为1/2，则组成唯一一组解，不增加情况。
            if (cur == '0') {
                if (pre == '1' || pre == '2') {
                    res = dp1;
                } else {
                    return 0;
                }
            } else if (sum > 10 && sum <= 26) {
                res = dp1 + dp2;
            }
            //前进
            dp1 = dp2;
            dp2 = res;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("31345"));
    }

}
