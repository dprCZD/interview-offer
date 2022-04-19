package interview.bintree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description:给定一个二叉树的根节点root，该树的节点值都在数字\ 0-9 0−9 之间，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 * @Date: 2022/2/12 22:42
 */

public class TreePathSum {

    public int sumNumbers(TreeNode root) {
        List<Integer> paths=new ArrayList<>();
        pathSum(root,paths,0);
        int res =0;
        for(int path:paths){
            res+=path;
        }
        return res;
    }

    private void pathSum(TreeNode root, List<Integer> paths, int curPath){
        if(root==null){
            return;
        }
        curPath=curPath*10+root.val;
        if(root.left==null&&root.right==null){
            paths.add(curPath);
            return;
        }
        pathSum(root.left,paths,curPath);
        pathSum(root.right,paths,curPath);

    }

}
