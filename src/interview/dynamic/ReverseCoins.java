package interview.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/5/27 21:57
 */
public class ReverseCoins {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<=1){
            return 0;
        }

        //构建 0-1序列需要的次数
        int num01 =0;
        for(int i =0;i<A.length;i++){
            if((i%2==0&&A[i] ==1)||(i%2 ==1 && A[i]==0)){
                num01++;
            }
        }
        //构建 1-0序列需要的次数
        int num10 =0;
        for(int i =0;i<A.length;i++){
            if((i%2==0&&A[i] ==0)||(i%2 ==1 && A[i]==1)){
                num10++;
            }
        }

        return Math.min(num01,num10);
    }

    public static void main(String[] args) {
        int[] A={0,1,1,0};

        System.out.println(solution(A));
    }

    public static int solution1(String S) {
        if(S==null ||S.length() == 0){
            return 0;
        }

        //转换为字符数组并过滤掉头部的0
        List<Character> binaries =new ArrayList<>();
        char[] chars = S.toCharArray();
        boolean flag =false;
        for(Character character:chars){
            if(!flag&&character == '0'){
                continue;
            }
            flag=true;
            binaries.add(character);
        }

        int res =0;
        while(binaries.size()>1){
            Character remove = binaries.remove(binaries.size() - 1);
            if(remove == '1'){
                binaries.add('0');
            }
            res++;
        }
        if(binaries.get(0) =='1'){
            res++;
        }
        return res;

    }



}
