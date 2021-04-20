package interview.dynamic;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * i-pre-1=(i-1)-(pre+1)+1
 * @Date: 2020/8/30 22:09
 */
public class MaxSquareHight {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]map=new int[n][m];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                int data=sc.nextInt();
                System.out.println(data);
                map[i][j]=data;
            }
        }
        System.out.println(maxHeight(map));
    }

    public static int maxHeight(int [][]map){
        if(map==null||map.length==0||map[0].length==0){
            return 0;
        }
        int maxArea=0;
        int height[]=new int[map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                height[j]=map[i][j]==0?0:height[j]+1;
            }
             maxArea=Math.max(maxSquare(height),maxArea) ;
        }
        return maxArea;
    }


    public static int maxSquare(int []height){
        if(height.length==0){
            return 0;
        }
        if(height.length==1){
            return height[0];
        }
        int maxSquare=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[stack.peek()]>=height[i]){
                int cur=stack.pop();
                int pre=stack.isEmpty()?-1:stack.peek();
                int curSquare=(i-pre-1)*height[cur];
                maxSquare=Math.max(maxSquare,curSquare);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int cur=stack.pop();
            int pre=stack.isEmpty()?-1:stack.peek();
            int curSquare=(height.length-pre-1)*height[cur];
            maxSquare=Math.max(maxSquare,curSquare);
        }
        return maxSquare;
    }
}
