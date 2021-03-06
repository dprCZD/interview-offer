package interview.list;

import model.ListNode;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/9/20 22:44
 */
public class CycleList {


    public static boolean hasCycle(ListNode head){
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                while(slow!=head){
                    slow=slow.next;
                    head=head.next;
                }
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head=ListNode.createList();
        System.out.println(hasCycle(head));
    }
}
