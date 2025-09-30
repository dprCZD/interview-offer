package interview.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/8/2 21:08
 */
public class MinStack {

    private LinkedList<Integer> dataList ;

    private LinkedList<Integer> minList;

    private int min =Integer.MAX_VALUE;

    public MinStack() {
        dataList = new LinkedList<>();
        minList = new LinkedList<>();

    }

    public void push(int val) {
        dataList.addLast(val);
        if(minList.isEmpty()|| min>=val)
        {
            minList.addLast(val);
            min = val;
        }
    }

    public void pop()
    {
        int val = dataList.removeLast();
        if(val == min)
        {
            minList.removeLast();
            if(!minList.isEmpty())
            {
                min = minList.getLast();
            }
            else
            {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return dataList.getLast();
    }

    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
//        MinStack stack=new MinStack();
//        Scanner sc=new Scanner(System.in);
//        int operateNum=Integer.valueOf(sc.nextLine());
//        for(int i=0;i<operateNum;i++){
//            String operateStr=sc.nextLine();
//            String []operate=operateStr.split(" ");
//            if("push".equals(operate[0])){
//                stack.push(Integer.valueOf(operate[1]));
//            }else if("pop".equals(operate[0])){
//                stack.pop();
//            }else if("getMin".equals(operate[0])){
//                System.out.println(stack.getMin());
//            }
//        }
    }
}




