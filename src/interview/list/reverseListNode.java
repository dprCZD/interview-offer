package interview.list;

import model.ListNode;

import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/9/13 18:56
 */
public class reverseListNode {


    public static ListNode reverseList(ListNode head){
       if(head==null||head.next==null){
           return head;
       }
       ListNode pre=head;
       ListNode cur=head.next;
       while(cur!=null){
           ListNode temp=cur.next;
           cur.next=pre;
           pre=cur;
           cur=temp;
       }
       head.next=null;
       return pre;

    }


    public static ListNode reverseDoubleList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            cur.last=temp;
            pre=cur;
            cur=temp;
        }
        head.next=null;
        return pre;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode head=new ListNode((sc.nextInt()));
        ListNode cur=head;
        for(int i=1;i<n;i++){
            cur.next=new ListNode(sc.nextInt());
            cur=cur.next;
        }

        int m=sc.nextInt();
        ListNode head2=new ListNode((sc.nextInt()));
        cur=head2;
        for(int i=1;i<m;i++){
            cur.next=new ListNode(sc.nextInt());
            cur.next.last=cur;
            cur=cur.next;
        }
        ListNode.printList(reverseList(head));
    }
}
