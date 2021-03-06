package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * 删除有序链表中重复出现的元素
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 给出的链表为1→2→3→3→4→4→5, 返回 1→2→5.
 * @Date: 2021/2/19 21:57
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates (ListNode head) {
        if(head==null ||head.next==null){
            return head;
        }
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            //如果两个节点相等
            if(cur.val == cur.next.val){
                //找出下个不相等的节点
                ListNode nextNode =cur.next.next;
                while(nextNode!=null&&nextNode.val==cur.val){
                    nextNode=nextNode.next;
                }
                //如果head为当前节点则直接跳到下个不相等节点
                if(head == cur){
                    head=nextNode;
                }
                //如果head不为当前节点则找出当前节点的前置节点，执行删除。
                else {
                    ListNode preNode =head;
                    while(preNode.next!=cur){
                        preNode=preNode.next;
                    }
                    preNode.next=nextNode;
                }
                cur= nextNode;
            }
            //不相等跳过
            else {
                cur=cur.next;
            }

        }
        return  head;
    }

}
