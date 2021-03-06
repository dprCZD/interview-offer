package interview.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/8/23 21:17
 */
public class dandiaoStack {


    /**
     * 核心思想是利用单调栈的特性。
     * 如果符合单调栈说明元素一直在增大
     * 如果不符合单调栈说明它是栈顶遇到的第一个比它小的元素。
     * @param array
     * @return
     */
    static int [][] getLRMin(int []array){
        Stack<Integer> stack=new Stack<>();
        int [][] res=new int[array.length][2];
        if(array.length==0){
            return res;
        }
        if(array.length==1){
            res[0][0]=-1;
            res[0][1]=-1;
            return res;
        }
        stack.push(array[0]);
        for(int i=0;i<array.length;i++){

            while (!stack.isEmpty()&&array[i]<array[stack.peek()]){
                int cur=stack.pop();
                if(stack.isEmpty()){
                    res[cur][0]=-1;
                }else {
                    res[cur][0]=stack.peek();
                }
                res[cur][1]=i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int cur=stack.pop();
            if(stack.isEmpty()){
                res[cur][0]=-1;
            }else {
                res[cur][0]=stack.peek();
            }
            res[cur][1]=-1;
        }
        return res;
    }


    /**
     * 核心思想是相同的元素归类为一个栈帧，统一处理。
     * @param array
     * @return
     */
    static int [][] getLRMinPre(int []array){
        Stack<List<Integer>> stack=new Stack<>();
        int [][] res=new int[array.length][2];
        if(array.length==0){
            return res;
        }
        if(array.length==1){
            res[0][0]=-1;
            res[0][1]=-1;
            return res;
        }
        for(int i=0;i<array.length;i++){

            while (!stack.isEmpty()&&array[i]<array[stack.peek().get(0)]){
                List<Integer> curList = stack.pop();
                int leftData=stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
                for(int cur:curList){
                    res[cur][0]=leftData;
                    res[cur][1]=i;
                }

            }
            if(!stack.isEmpty()&&array[stack.peek().get(0)]==array[i]){
                stack.peek().add(i);
            }else{
                List<Integer> list=new ArrayList<>(2);
                list.add(i);
                stack.push(list);
            }
        }
        while(!stack.isEmpty()){
            List<Integer> curList = stack.pop();
            int leftData=stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
            for(int cur:curList){
                res[cur][0]=leftData;
                res[cur][1]=-1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int array[]=new int[num];
        for (int i=0;i<array.length;i++){
            array[i]=sc.nextInt();
        }
        int[][] lrMin = getLRMinPre(array);
        if(lrMin.length==0){
            return;
        }
        for (int[] ints : lrMin) {
            for (int j = 0; j < lrMin[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
