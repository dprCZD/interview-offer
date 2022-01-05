package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/7/11 23:08
 */
public class AddList {

    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //> 先反转，将低位转换到链表头
        head1 = reverse(head1);
        head2 = reverse(head2);
        //> 通过哨兵结点头插
        ListNode sentinel = new ListNode(-1);
        boolean carry = false;
        //> 执行相加
        while (head1 != null || head2 != null || carry) {
            //> 获取因数
            int a = head1 == null ? 0 : head1.val;
            int b = head2 == null ? 0 : head2.val;
            //> 获取和
            int sum = carry ? a + b + 1 : a + b;
            //> 处理进位
            carry = sum / 10 == 1;
            //> 将和插入链表
            ListNode node = new ListNode(sum % 10);
            if (sentinel.next == null) {
                sentinel.next = node;
            } else {
                node.next = sentinel.next;
                sentinel.next = node;
            }
            //> 推进链表
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        return sentinel.next;

    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;

    }
}
