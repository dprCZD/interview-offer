package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @Date: 2021/2/19 22:21
 */
public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int len1 =0 ;
        int len2 =0;
        ListNode cur1=pHead1;
        ListNode cur2 =pHead2;
        while(cur1!=null){
            len1++;
            cur1=cur1.next;
        }
        cur1=pHead1;
        while(cur2!=null){
            len2++;
            cur2=cur2.next;
        }
        cur2=pHead2;
        int dis =len1 -len2;
        if(dis < 0){
            dis = Math.abs(dis);
            while(dis>0){
                cur2 =cur2.next;
                dis--;
            }
        } else if (dis>0) {
            while ((dis>0)){
                cur1 =cur1.next;
                dis--;
            }
        }

        while (cur1 !=null && cur2 != null){
            if(cur1.val ==cur2.val){
                return cur1;
            }
            cur1=cur1.next;
            cur2 =cur2.next;
        }
        return null;


    }
}
