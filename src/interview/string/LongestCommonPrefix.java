package interview.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/1/18 22:52
 */
public class LongestCommonPrefix {

    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char findChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || findChar != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }
}
