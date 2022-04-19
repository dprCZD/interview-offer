package interview.bintree;

import model.TreeNode;

import java.util.*;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/14 23:12
 */
public class isSearchTree {


    public boolean[] judgeIt(TreeNode root) {
        // write code here

        return new boolean[]{isSearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE),isFullTree(root)};
    }

    private boolean isSearchTree(TreeNode root,int left,int right ) {
        if (root == null) {
            return true;
        }
        if (root.val<=left || root.val>=right) {
            return false;
        }
        return isSearchTree(root.left,left,root.val) && isSearchTree(root.right,root.val,right);

    }

    private boolean isFullTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false; //标记是否遇到节点不双全的节点
        while(!queue.isEmpty()){
            root = queue.poll();
            TreeNode left = root.left;
            TreeNode right = root.right;
            //遇到左右孩子不双全的节点并且该节点不是叶子节点的时候就不是完全二叉树  //左孩子为空并且右孩子不为空的时候不是完全二叉树
            if((flag && !(left == null && right == null)) || (left == null && right != null)){
                return false;
            }
            if(left != null)    queue.offer(left);
            if(right != null)   queue.offer(right);
            if(left == null || right == null)   flag = true;
        }
        return true;

    }
}
