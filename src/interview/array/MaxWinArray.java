package interview.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: czd
 * @Description: 核心在于数组下标的应用，这一点平时不容易想到。双端队列中按大小存储当前偏离中的
 * @Date: 2020/8/16 23:18
 */
public class MaxWinArray {



    public static int[] getMaxWinArray(int[] array,int winLen){
        Deque<Integer> maxQue=new LinkedList<>();
        int[]res=new int[array.length-winLen+1];

        for(int i=0;i<array.length;i++){
            while (!maxQue.isEmpty()&&array[maxQue.peekLast()]<=array[i]){
                maxQue.pollLast();
            }
            maxQue.addLast(i);
            if(maxQue.peekFirst()==i-winLen){
                maxQue.pollFirst();
            }
            if(i-winLen+1>=0){
                res[i-winLen+1]=array[maxQue.peekFirst()];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arrLen=sc.nextInt();
        int winLen=sc.nextInt();
        int []array=new int[arrLen];
        for(int i=0;i<arrLen;i++){
            array[i]=sc.nextInt();
        }
        int res[]=getMaxWinArray(array,winLen);
        for(int i=0;i<arrLen-winLen+1;i++){
            System.out.print(res[i]+" ");
        }
    }

}
