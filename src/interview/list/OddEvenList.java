package interview.list;

import model.ListNode;

/**
 * @Author: czd
 * @Description:
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 * @Date: 2022/2/16 22:30
 */
public class OddEvenList {


    public ListNode oddEvenList (ListNode head) {
        // write code here
        //> 构造初始数据
        ListNode odd =new ListNode(0);
        ListNode even =new ListNode(0);
        ListNode oddCur =odd;
        ListNode evenCur =even;
        int i=1;
        //> 执行重排序
        while(head!=null){
            if(i%2==1){
                oddCur.next=head;
                oddCur=oddCur.next;
            }else{
                evenCur.next=head;
                evenCur=evenCur.next;
            }
            i++;
            head=head.next;
        }
        //> 数据收尾处理
        evenCur.next=null;
        oddCur.next=even.next;
        return odd.next;
    }
}
