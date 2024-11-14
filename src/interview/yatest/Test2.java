package interview.yatest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test2 {

    int res = 0;

    int maxCornSum(int[][]coins,String[][]colors,int n,int m,int k){
        dfs(coins,colors,0,0,coins[0][0],n,m,k);
        HashMap<Integer,Integer> map;
        return res;
    }

    void dfs(int[][]coins,String[][] colors, int x,int y,int value, int n, int m, int k){
        res = Math.max(res,value);
        if(x == n-1&&y == m-1){
            return;
        }
        if(x+1<n){
            if(colors[x+1][y].equals(colors[x][y])){
                dfs(coins,colors,x+1,y,value+coins[x+1][y],n,m,k);
            }else if(value-k>=0){
                dfs(coins,colors,x+1,y,value+coins[x+1][y]-k,n,m,k);
            }
        }
        if(y+1<m){
            if(colors[x][y+1].equals(colors[x][y])){
                dfs(coins,colors,x,y+1,value+coins[x][y+1],n,m,k);
            }else if(value-k>=0){
                dfs(coins,colors,x,y+1,value+coins[x][y+1]-k,n,m,k);
            }
        }
    }
    public static void main(String[] args)
    {
/*        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s1 = line.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        String[][] colors = new String[n][m];
        for (int i=0;i<n;i++){
            line = scanner.nextLine();
            for(int j=0;j<m;j++){
                colors[i][j]=line.substring(j,j+1);
            }
        }
        int[][] value = new int[n][m];
        for (int i=0;i<n;i++){
            line = scanner.nextLine();
            s1 = line.split(" ");
            for(int j=0;j<m;j++){
                value[i][j]=Integer.parseInt(s1[j]);
            }
        }
        System.out.println(new Test2().maxCornSum(value,colors,n,m,k));*/

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n =Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] children = new int[n];
        String[] childrenStr = sc.nextLine().split(" ");
        for(int i =0;i<n;i++){
            children[i] = Integer.parseInt(childrenStr[i]);
        }
        int[] cookies = new int[m];
        String[] cookiesStr = sc.nextLine().split(" ");
        for(int i =0;i<m;i++){
            cookies[i] = Integer.parseInt(cookiesStr[i]);
        }
        System.out.println(getMaxCookies(children,cookies));

    }

    public static int getMaxCookies(int[] children, int[] cookies){
        Arrays.sort(children);
        Arrays.sort(cookies);
        int sum=0;
        int j=0;
        for (int child : children) {
            while (j < cookies.length && child > cookies[j])
                j++;
            if (j < cookies.length && child <= cookies[j]) {
                sum = sum + 1;
                j++;
            }
        }
        return sum;
    }

}
