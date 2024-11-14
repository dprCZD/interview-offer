package interview.yatest;

import java.util.Scanner;

public class Test4 {


    static int maxCandies(int[] candies){
        int n =candies.length;
        if(n  == 1){
            return candies[0];
        }
        if(n == 2){
            return Math.max(candies[0],candies[1]);
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1]=candies[0];
        dp[2] = candies[1];
        for(int i =3;i<=n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]);
            dp[i] = Math.max(dp[i],candies[i-1]+dp[i-3]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] candies = new int[n];
        for(int i =0;i<n;i++){
            candies[i] = scanner.nextInt();
        }
        System.out.println(maxCandies(candies));
    }
}
