package interview.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: czd
 * @Description: 用一个栈实现另一个栈的排序
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * @Date: 2020/8/16 22:48
 */
public class SortStack {



    public static void sortStack(Stack<Integer> stack){
        Stack<Integer>help=new Stack<>();
        while(!stack.isEmpty()){
            int cur=stack.pop();
            while(!help.isEmpty()&&cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<num;i++){
            stack.push(sc.nextInt());
        }
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
