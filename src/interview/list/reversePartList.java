package interview.list;

import model.ListNode;

import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/9/20 22:12
 */
public class reversePartList {


    public static ListNode reverseList(ListNode head,int from,int to){
        if(head==null||head.next==null){
            return head;
        }

        int index=1;
        ListNode iNode=head;
        ListNode fPre=null;
        ListNode tAf=null;
        //遍历寻找前节点和后节点
        while(iNode!=null){
            if(index==from-1){
                fPre=iNode;
            }
            if(index==to+1){
                tAf=iNode;
            }
            iNode=iNode.next;
            index++;
        }
        if(index<from){
            return head;
        }

        ListNode pre;
        //如果fPre为空说明from=1，pre为head，否则pre=fPre.next
        if(fPre==null){
            pre=head;
        }else {
            pre=fPre.next;
            if(pre==null){
                return head;
            }
        }
        ListNode cur=pre.next;
        while(cur!=tAf){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        //如果fPre为空说明from=1，需要换头，否则替换fPre.next。
        if(fPre==null){
            head.next=tAf;
            head=pre;
        }else{
            fPre.next.next=tAf;
            fPre.next=pre;
        }
        return head;
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
        int from=sc.nextInt();
        int to =sc.nextInt();
        ListNode.printList(reverseList(head,from,to));
    }
}
