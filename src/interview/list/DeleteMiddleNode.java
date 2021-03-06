package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/9/13 18:38
 */
public class DeleteMiddleNode {


    public static ListNode deleteMiddleNode(ListNode head){

        if(head==null||head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }
        ListNode pre=head;
        ListNode cur=head.next.next;
        while(cur.next!=null&&cur.next.next!=null){
            pre=pre.next;
            cur=cur.next.next;
        }
        pre.next=pre.next.next;
        return head;
    }

    public static ListNode deleteABNode(ListNode head,int a,int b){
        if(a<1||a>b){
            return head;
        }
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        int index=(int)Math.ceil((double)(a*len)/(double)b);
        if(index==1){
            return head.next;
        }
        cur=head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}
