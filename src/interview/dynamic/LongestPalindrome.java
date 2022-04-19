package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/1/27 21:47
 */
public class LongestPalindrome {


    public static void main(String[] args) {
        new LongestPalindrome().getLongestPalindrome("baabccc");
    }
    /**
     * 中心扩散法
     *
     * @param A
     * @return
     */
    public int getLongestPalindrome1(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        // write code here
        int max = 1;
        for (int i = 0; i < A.length(); i++) {
            //> 找出前后相同的串
            int left = i;
            int right = i;
            while (left - 1 > 0 && A.charAt(left - 1) == A.charAt(i)) {
                left--;
            }
            while (right + 1 < A.length() && A.charAt(right + 1) == A.charAt(i)) {
                right++;
            }
            int len = getPalindrome(A, left - 1, right + 1);
            max = Math.max(len, max);
        }
        return max;
    }

    private int getPalindrome(String A, int left, int right) {
        while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            left--;
            right++;
        }
        ;
        return right - left - 1;
    }


    /**
     * @param A
     * @return
     */
    public int getLongestPalindrome(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        // write code here
        boolean dp[][] = new boolean[A.length()][A.length()];
        int max = 1;
        //> 初始化
        for (int i = 0; i < A.length(); i++) {
            dp[i][i] = true;
        }

        //> dp算法
        for (int left = 1; left < A.length(); left++) {
            for (int right = 0; right <= left; right++) {
                if (A.charAt(left)==A.charAt(right)){
                    //>
                    if(left==right){
                        dp[left][right]=true;
                    } else if (left-right<2){
                        dp[left][right]=true;
                    } else {
                        dp[left][right]=dp[left-1][right+1];
                    }
                    if(dp[left][right]&&left-right+1>max){
                        max=left-right+1;
                    }
                }
            }
        }
        return max;
    }
}
