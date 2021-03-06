package interview.list;

import model.ListNode;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/10/7 20:34
 */
public class huiwenList {


    public static boolean isHuiWenList(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        //获取链表的长度
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }

        int half=len/2;
        Stack<Integer> stack=new Stack<>();
        cur=head;
        for(int i=0;i<half;i++){
            stack.push(cur.val);
            cur=cur.next;
        }

        //如果是奇数，跳过中间节点
        if(len%2==1){
            cur=cur.next;
        }
        while(!stack.isEmpty()){
            Integer sv = stack.pop();
            Integer cv=cur.val;
            if(!sv.equals(cv)){
                return false;
            }
            cur=cur.next;
        }
        return true;
    }



    public static void main(String[] args) {
        ListNode head=ListNode.createList();
        System.out.println(isHuiWenList(head));;
    }
}
