package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description: 删除有序链表中重复出现的元素
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 给出的链表为1→2→3→3→4→4→5, 返回 1→2→5.
 * @Date: 2021/2/19 21:57
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (pre.val!=cur.val) {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;

    }

}
