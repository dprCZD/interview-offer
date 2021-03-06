package interview.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * 用递归函数和栈逆序一个栈
 * 一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 * @Date: 2020/8/12 22:38
 */
public class ReserveStack {





     static  Integer getAndRemoveLast(Stack<Integer>stack){
        Integer res=stack.pop();
        if(stack.isEmpty()){
            return res;
        }else{
            Integer last=getAndRemoveLast(stack);
            stack.push(res);
            return last;
        }
    }

     static void reserveStack(Stack<Integer>stack){
        if(!stack.isEmpty()){
            Integer res=getAndRemoveLast(stack);
            reserveStack(stack);
            stack.push(res);
        }

    }

    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();

        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int data=sc.nextInt();
            stack.add(data);
        }
        reserveStack(stack);
        for(Integer i:stack){
            System.out.print(i+" ");
        }

    }
}
