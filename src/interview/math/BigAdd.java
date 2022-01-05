package interview.math;

/**
 * @Author: czd
 * @Description:
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 * @Date: 2021/7/3 23:35
 */
public class BigAdd {

    public static String add (String s, String t) {
        // write code here

        StringBuilder builder  =new StringBuilder();
        int len1= s.length();
        int len2 = t.length();
        int n =Math.max(len1,len2);
        //>补0操作
        StringBuilder zeroBuilder =new StringBuilder();
        for(int i = 0;i<Math.abs(len1-len2);i++){
            zeroBuilder.append("0");
        }
        if(len1>len2){
            t=zeroBuilder.append(t).toString();
        } else if (len2>len1) {
            s=zeroBuilder.append(s).toString();
        }
        //>执行相加
        boolean flag =false;
        for(int i=0;i<n;i++){
            int a1 =s.charAt(n-1-i)-'0';
            int a2 = t.charAt(n-1-i) -'0';
            int sum = flag? a1+a2+1:a1 +a2;
            flag = sum/10 ==1 ;
            builder.insert(0, sum % 10);
        }
        //>末尾是否有进位
        if(flag){
            builder.insert(0,"1");
        }

        return builder.toString();
    }

    /**
     * 代码好看，简洁。
     * @param s
     * @param t
     * @return
     */
    public String solve(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0, i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.insert(0, sum % 10);//插入到s字符串的第一个位置
            carry = sum / 10;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(add("1","99"));
    }
}
