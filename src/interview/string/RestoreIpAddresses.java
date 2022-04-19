package interview.string;

import java.util.ArrayList;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/26 22:18
 */
public class RestoreIpAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        restore(s, s.length(), 0, "", res);
        return res;
    }

    private void restore(String s, int index, int num, String cur, ArrayList<String> res) {
        //>递归出口
        if (index <= 0) {
            return;
        }
        if (num == 3) {
            String finalStr = s.substring(0, index);
            if(finalStr.length()>1&&finalStr.charAt(0)=='0'){
                return;
            }

            if (Integer.parseInt(finalStr) < 256) {
                    cur = finalStr + "." + cur;
                    res.add(cur.substring(0,cur.length()-1));
            }
        }
        //>
        if (index - 1 > 0) {
            restore(s, index - 1, num + 1, s.substring(index - 1, index) + "." + cur, res);
        }
        if (index - 2 > 0&&s.charAt(index-2)!='0') {
            restore(s, index - 2, num + 1, s.substring(index - 2, index) + "." + cur, res);
        }
        if (index - 3 > 0&&s.charAt(index-3)!='0') {
            String str = s.substring(index - 3, index);
            if (Integer.parseInt(str) < 256) {
                restore(s, index - 3, num + 1, str + "." + cur, res);
            }
        }
    }

    public static void main(String[] args) {
        new RestoreIpAddresses().restoreIpAddresses("25525522135");
    }
}
