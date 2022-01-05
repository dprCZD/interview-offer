package interview.string;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/7/4 23:03
 */
public class ReverseString {

    public String reverse (String str) {
        // write code here
        if(str == null||str.isEmpty()){
            return str;
        }
        int start =0;
        int end =str.length()-1;
        char []array =str.toCharArray();
        char temp;
        while(start<end){
            temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
        return String.valueOf(array);
    }
}
