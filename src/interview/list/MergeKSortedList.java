package interview.list;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description: 合并\ k k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度

 * @Date: 2021/3/6 20:53
 */
public class MergeKSortedList {

    /**
     * 解法：核心是将链表俩俩之间使用归并算法进行合并，最后得出结果
     * 时间复杂度：(k-1)*(x+2x+3x+....kx)=(2k-1)*(k-1)*x=O(2k平方x),其中k为链表个数，x为链表的平均长度
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null||lists.isEmpty()){
            return null;
        }
        ListNode head = lists.get(0);
        for(int i=1;i<lists.size();i++){
            head=mergeList(head,lists.get(i));
        }
        return head;
    }


    /**
     * 解法：核心是将链表俩俩之间使用归并算法进行合并，最后得出结果，这里的优化点是22合并，减少时间复杂度
     * 时间复杂度：logk*(x+2x+4x+8x...kx)=logk*(k-1)x=O(kxlogk)=O(nlogk);
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        if(lists==null||lists.isEmpty()){
            return null;
        }

        return mergeKLists1(lists,0,lists.size()-1);
    }

    private ListNode mergeKLists1(ArrayList<ListNode> lists,int start,int end) {
        if(end<=start){
            return lists.get(start);
        }

        int mid =(end+start)/2;
        ListNode left= mergeKLists1(lists,start,mid);
        ListNode right =mergeKLists1(lists,mid+1,end);
        return mergeList(left,right);
    }


    private ListNode mergeList(ListNode listA,ListNode listB){
        if(listA ==null){
            return listB;
        }
        if(listB == null){
            return listA;
        }
        ListNode head ;
        if(listA.val>listB.val){
            head=listB;
            listB=listB.next;

        } else {
            head=listA;
            listA=listA.next;
        }

        ListNode cur=head;
        while(listA!=null&&listB!=null){
            if(listA.val>listB.val){
                cur.next=listB;
                listB=listB.next;
                cur=cur.next;
            } else {
                cur.next=listA;
                listA=listA.next;
                cur=cur.next;
            }
        }
        while(listA!=null){
            cur.next=listA;
            listA=listA.next;
            cur=cur.next;
        }
        while(listB!=null){
            cur.next=listB;
            listB=listB.next;
            cur=cur.next;
        }
        return head;
    }
}
