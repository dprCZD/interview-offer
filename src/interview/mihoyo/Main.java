package interview.mihoyo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int maxPow =1;
        while(maxPow<n){
            maxPow *=3;
        }
        String res =getExpr(n,maxPow);
        System.out.println(res.substring(1));
    }

    public static String getExpr(int n, int pow){
        if( n == 0){
            return "";
        }
        if(pow == 1){
            if(n-1 ==0){
                return "+1";
            }
            if(n+1 == 0){
                return "-1";
            }
            return "error";
        }
        String res = getExpr(n,pow/3);
        if(!"error".equals(res)){
            return res;
        }
        res = getExpr(n-pow,pow/3);
        if(!"error".equals(res)){
            return "+"+pow+res;
        }
        res = getExpr(n+pow,pow/3);
        if(!"error".equals(res)){
            return "-"+pow+res;
        }
        return "error";
    }

}
