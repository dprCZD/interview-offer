package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/12/13 21:22
 */
public class MergeList {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here

        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head=new ListNode();
        ListNode p=head;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                p.next=l2;
                l2=l2.next;
            } else{
                p.next=l1;
                l1=l1.next;
            }
            p=p.next;
        }
        if(l1!=null){
            p.next=l1;
        }
        if(l2!=null){
            p.next=l2;
        }
        return head.next;

    }
}
