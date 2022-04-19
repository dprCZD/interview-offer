package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/1/13 22:37
 */
public class SortList {
    public static void main(String[] args) {
        ListNode.printList(new SortList().sortInList(ListNode.createList()));
        ;
    }

    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        //> 找到中点,开头不一致时找到的中点是偏左中点，一致时是偏右中点。
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(temp);

        //>进行链表归并
        ListNode newHead = new ListNode();
        temp = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        while (left != null) {
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return newHead.next;
    }
}

