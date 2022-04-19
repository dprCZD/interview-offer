package interview.string;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/21 23:11
 */
public class isPalindromeString {

    public boolean judge (String str) {
        // write code here
        if(str==null||str.isEmpty()){
            return true;
        }
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length/2;i++){
            if(chars[i]!=chars[chars.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
