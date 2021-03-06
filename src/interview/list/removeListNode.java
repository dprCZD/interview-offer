package interview.list;

import model.ListNode;

import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/9/6 22:26
 */
public class removeListNode {

    static ListNode removeNode(ListNode head,int k){
        if(k<1||head==null){
            return head;
        }
        ListNode cur=head;
        while(cur!=null){
            k--;
            cur=cur.next;
        }
        if(k==0){
            return head.next;
        }
        if(k>0){
            return head;
        }
        cur=head;
        k++;
        while(k!=0){
            cur=cur.next;
            k++;
        }
        cur.next=cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int k=sc.nextInt();
        if(num==0){
            return;
        }
        ListNode head=new ListNode((sc.nextInt()));
        ListNode cur=head;
        for(int i=1;i<num;i++){
            cur.next=new ListNode(sc.nextInt());
            cur=cur.next;
        }
        removeNode(head,k);
        cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }


}
