package interview.string;

/**
 * @Author: czd
 * @Description:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * @Date: 2021/4/5 20:47
 */
public class CountPalindromeSubstrings {


    /**
     * 解法：中心扩散法，找出所有回文中心，扩散遍历。回文中心可能由2种，一种是单个，一种是2个，比如aba和abba。
     * 因此遍历所有回文中心的数为2n-1，每个回文中心的左起点为i/2;右起点为left+i%2;
     * 时间复杂度：n2;空间复杂度：1
     * @param s
     * @return
     */

    public int countSubstrings(String s) {
        if(s == null ||s.length()==0){
            return 0;
        }
        int n =s.length();

        int res =0;

        for(int i =0;i<2*n-1;i++){
            int left =i/2;
            int right =left+i%2;
            //计算回文数
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;

    }
}
