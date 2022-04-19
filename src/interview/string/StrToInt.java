package interview.string;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/17 21:07
 */
public class StrToInt {

    public int StrToInt (String s) {
        // write code here
        if(s==null||s.isEmpty()){
            return 0;
        }

        char[] chars = s.toCharArray();
        long res=0;
        boolean flag =true;//> 是否正数
        int i=0;

        //> 前导空格
        for(;i<chars.length;i++){
            if(chars[i]!=' '){
                break;
            }
        }
        if(i>=chars.length){
            return 0;
        }
        //> 前导符号
        if(chars[i] =='-'){
            flag=false;
            i++;
        }else if(chars[i] =='+'){
            i++;
        }
        //> 遍历字符串
        for(;i<chars.length;i++){

            //> 数字处理
            if(chars[i]>='0'&&chars[i]<='9'){
                res=res*10+chars[i]-'0';
                if(res>Integer.MAX_VALUE){
                    return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }else if (res==Integer.MAX_VALUE){
                    return flag?Integer.MAX_VALUE:-Integer.MAX_VALUE;
                }
                continue;
            }
            return flag?(int)res:(int)-res;
        }
        return flag?(int)res:(int)-res;

    }


}
