package interview.yatest;

import java.util.*;
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        int maxWeight = 0;
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            maxWeight =Math.max(maxWeight,queries[i]);
        }
        int[][] dp =new int[n+1][maxWeight+1];
        int[] res = new int[m];
        int curWeight = 0;
        for (int i = 0; i < m; i++) {
            res[i] = getMaxPlates(a,queries[i],dp, curWeight);
            curWeight =Math.max(curWeight,queries[i]);
        }
        for(int num:res){
            System.out.print(num + " ");
        }
    }

    public static int getMaxPlates(int[] a, int q, int [][] dp,int curWeight) {
        int n = a.length;
        if(q<= curWeight){
            return dp[n][q];
        }
        for(int i =1;i<=n;i++){
            for(int j = curWeight+1;j<=q;j++){
                int weight =a[i-1]*a[i-1];
                if(weight>j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+1);
                }
            }
        }
        return dp[n][q];
    }
}

