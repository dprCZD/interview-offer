package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/7/3 23:20
 */
public class RemoveNthFromEnd {

    /**
     * 两边遍历删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        //> 获取长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        //> 如果是头节点直接返回next
        if(n == len){
            return head.next;
        } else if(n>len){
            return null;
        }
        cur =head;
        for(int i =0;i<len-n-1;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }

    /**
     * 快慢指针法，先让快指针走n步。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode fast =head;
        ListNode slow =head;
        while(n>0){
            fast=fast.next;
            n--;
        }
        //> 如果走到了null，n和链表长度一样，删除头节点。
        if(fast == null){
            return head.next;
        }
        //> 将慢指针移动到待删除结点的前一个结点。
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //> 执行删除
        slow.next=slow.next.next;
        return head;

    }
}
