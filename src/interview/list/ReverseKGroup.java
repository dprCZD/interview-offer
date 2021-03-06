package interview.list;

import model.ListNode;

import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/2/6 20:16
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head==null||head.next==null||k<2){
            return head;
        }
        ListNode pre =head;
        ListNode cur = head.next;
        ListNode preGroupEnd =null;
        int total =0;
        while(pre!=null){
            pre=pre.next;
            total++;
        }
        pre =head;

        for (int q =0; ;q++){
            int i=0;
            //记录当前组未反转的头节点
            ListNode curGroupHead = pre;
            while(i<k-1&&cur!=null&&total-q*k>=k){
                ListNode temp =cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
                i++;
            }

            //记录整体的head
            if(q==0){
                head = pre;
            }

            //上一组的尾节点指向本组反转后的头节点
            if(preGroupEnd!=null){
                preGroupEnd.next=pre;
            }

            //当前节点为空，说明已到尾巴，跳出循环。
            if(cur==null){
                //尾巴置空
                curGroupHead.next=null;
                return head;
            }
            //前进一格，进入到下一组的反转
            pre=cur;
            cur=cur.next;
            //将本组的尾节点（反转前的头节点）设置为preGroupEnd
            preGroupEnd=curGroupHead;

        }
    }

    public static void main(String[] args) {
        ListNode node =reverseKGroup(ListNode.createList(),2);
        ListNode.printList(node);
    }
}
