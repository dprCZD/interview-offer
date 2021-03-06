package interview.bintree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/10/8 16:52
 */
public class BinTree {

    public  int[][] threeOrders (TreeNode root) {
        // write code here
        int[][]res=new int[3][];
        List<Integer> resList=new ArrayList<>();
        preTrval(root,resList);
        res[0]=convertArray(resList);
        resList.clear();
        midTrval(root,resList);
        res[1]=convertArray(resList);
        resList.clear();
        afterTrval(root,resList);
        res[2]=convertArray(resList);

        return res;

    }


    public  void preTrval(TreeNode root,List<Integer> res){
        //如果为空直接返回
        if(root==null){
            return;
        }
        res.add(root.val);
        preTrval(root.left,res);
        preTrval(root.right,res);
    }

    public  void midTrval(TreeNode root,List<Integer> res){
        //如果为空直接返回
        if(root==null){
            return;
        }
        midTrval(root.left,res);
        res.add(root.val);
        midTrval(root.right,res);
    }

    public  void afterTrval(TreeNode root,List<Integer> res){
        //如果为空直接返回
        if(root==null){
            return;
        }
        afterTrval(root.left,res);
        afterTrval(root.right,res);
        res.add(root.val);
    }

    public int[] convertArray(List<Integer>list){
        int[] res =new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
