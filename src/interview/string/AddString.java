package interview.string;

/**
 * @Author: czd
 * @Description: 实现加法。
 * @Date: 2021/3/28 23:47
 */
public class AddString {

    public String addStrings(String num1, String num2) {
        //判空
        if (num1 == null) {
            return num2;
        } else if (num2 == null) {
            return num1;
        }

        //转换数据
        char[] num1s = num1.toCharArray();
        int pointer1 = num1s.length - 1;
        char[] num2s = num2.toCharArray();
        int pointer2 = num2s.length - 1;

        //竖式相加模拟计算
        StringBuilder resBuilder = new StringBuilder();
        int add = 0;//进位标识符
        //这里以较长的数为循环结束点,当指针<0时补0;
        while (pointer1 >= 0 || pointer2 >= 0) {
            //转换为数字
            int cur1 = pointer1 >= 0 ? num1s[pointer1] - 48 : 0;
            int cur2 = pointer2 >= 0 ? num2s[pointer2] - 48 : 0;
            int res = cur1 + cur2 + add;
            //取进位
            add = res / 10;
            res = res % 10;
            resBuilder.append(res);
            pointer1--;
            pointer2--;
        }
        //循环结束可能产生进位
        if(add==1){
            resBuilder.append(1);
        }
        return resBuilder.reverse().toString();
    }
}
