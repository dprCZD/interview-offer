package interview.list;

import model.ListNode;

import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @Date: 2021/4/24 20:55
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null||head.next==null){
            return;
        }

        ListNode mid = getMiddleNode(head);
        ListNode l2 =mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        ListNode l1 =head;

        //插入
        ListNode temp1;
        ListNode temp2;
        while(l1 !=null &&l2!=null){
            temp1 =l1.next;
            temp2 =l2.next;
            l1.next=l2;
            l2.next=temp1;
            l1=temp1;
            l2=temp2;
        }


    }

    private ListNode getMiddleNode(ListNode head){
        //找到中点
        ListNode slow =head;
        ListNode fast =head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        //逆序链表
        ListNode pre =head;
        ListNode cur =head.next;
        while (cur !=null){
            ListNode temp =cur.next;
            cur.next = pre;
            pre =cur;
            cur =temp;
        }
        head.next=null;
        return  pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList();
        new ReorderList().reorderList(head);
    }
}
