package interview.list;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/9/6 22:04
 */
public class CommonListData {



    public static  List<Integer> getCommon(ListNode h1, ListNode h2){
        List<Integer>res =new ArrayList<>();

        if(h1==null||h2==null){
            return res;
        }
        while(h1!=null&&h2!=null){
            if(h1.val>h2.val){
                h2=h2.next;
            }else if(h1.val<h2.val){
                h1=h1.next;
            }else{
                res.add(h1.val);
                h1=h1.next;
                h2=h2.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        ListNode h1=getInput(scanner);
        ListNode h2=getInput(scanner);
        List<Integer> common = getCommon(h1, h2);
        for(Integer data:common){
            System.out.print(data+" ");
        }

    }

    static ListNode getInput(Scanner scanner){
        int num= scanner.nextInt();
        ListNode h=new ListNode(scanner.nextInt());
        ListNode cur=h;
        for(int i=1;i<num;i++){
            cur.next=new ListNode(scanner.nextInt());
            cur=cur.next;
        }
        return h;
    }
}
