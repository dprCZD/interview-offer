package model;


import java.util.Scanner;

public class ListNode {

  public int val;

  public ListNode next;

  public ListNode last;

  public ListNode(int x) {
      val = x;
  }

    public ListNode() {

    }

  public static void printList(ListNode head){
    ListNode cur = head;
    while(cur!=null){
      System.out.print(cur.val+" ");
      cur=cur.next;
    }
  }

  public static ListNode createList(){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ListNode head = new ListNode((sc.nextInt()));
    ListNode cur = head;
    for (int i = 1; i < n; i++) {
      cur.next = new ListNode(sc.nextInt());
      cur = cur.next;
    }
    return head;
  }

}
