package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * @Date: 2022/3/20 22:43
 */
public class FindKthToTail {

    public ListNode findKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead==null){
            return null;
        }
        //>
        ListNode fast =pHead;
        while(k>0){
            //> 如果为空说明链表长度<k
            if(fast == null){
                return null;
            }
            fast= fast.next;
            k--;
        }
        ListNode slow =pHead;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
