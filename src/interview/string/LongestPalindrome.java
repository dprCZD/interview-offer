package interview.string;

/**
 * @Author: czd
 * @Description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * @Date: 2021/4/5 21:04
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String res = "";

        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            String temp = "";
            //计算回文数
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                temp = left == right ? String.valueOf(s.charAt(left)) : s.charAt(left) + temp + s.charAt(right);
                left--;
                right++;
            }
            if (temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;

    }
}
