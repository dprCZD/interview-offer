package easy;

import java.util.ArrayList;
import java.util.List;

public class No05 {

    public String replaceSpace(String s) {
        char []array=s.toCharArray();
        StringBuilder builder=new StringBuilder();
        for(char item:array){
            if(item==32){
                builder.append('%');
                builder.append('2');
                builder.append('0');
            }else {
                builder.append(item);
            }
        }
       return builder.toString();

    }
}
