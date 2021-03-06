package interview.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/8/2 21:36
 */
public class StackQueue {

    Stack<Integer> fStack=new Stack<>();

    Stack<Integer> sStack=new Stack<>();


    public void add(Integer value){
        fStack.push(value);
    }

    public Integer peek(){
        if(sStack.isEmpty()){
            if(fStack.isEmpty()){
                return Integer.MIN_VALUE;
            }
            while (!fStack.isEmpty()){
                sStack.push(fStack.pop());
            }
        }
        return sStack.peek();
    }

    public Integer poll(){
        Integer value=this.peek();
        return value==Integer.MIN_VALUE?Integer.MIN_VALUE:sStack.pop();
    }

    public static void main(String[] args) {
        StackQueue queue=new StackQueue();
        Scanner sc=new Scanner(System.in);
        int operateNum=Integer.valueOf(sc.nextLine());
        for(int i=0;i<operateNum;i++){
            String operateStr=sc.nextLine();
            String []operate=operateStr.split(" ");
            if("add".equals(operate[0])){
                queue.add(Integer.valueOf(operate[1]));
            }else if("poll".equals(operate[0])){
                queue.poll();
            }else if("peek".equals(operate[0])){
                System.out.println(queue.peek());
            }
        }
    }
}
