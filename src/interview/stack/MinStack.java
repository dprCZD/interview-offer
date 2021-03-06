package interview.stack;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/8/2 21:08
 */
public class MinStack {

    LinkedList<Integer> dataStack;

    LinkedList<Integer> minStack;

    MinStack(){
        this.dataStack=new LinkedList<>();
        this.minStack=new LinkedList<>();
    }

    public void push(Integer value){
        dataStack.add(value);
        if(minStack.isEmpty()){
            minStack.add(value);
        }else if(this.getMin()>=value){
            minStack.add(value);
        }
    }

    public Integer pop(){
        Integer popValue=dataStack.removeLast();
        if(popValue.equals(minStack.getLast())){
            minStack.removeLast();
        }
        return popValue;
    }

    public Integer getMin(){
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.getLast();
    }

    public Integer peek(){
        if(dataStack.isEmpty()){
            return -1;
        }
        return dataStack.getLast();
    }

    static int test(){
        int i=1;
    try{
        return i++;
    }
    finally {
        return i+5;

    }
    }
    public static void main(String[] args) {
        System.out.println(test());
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
