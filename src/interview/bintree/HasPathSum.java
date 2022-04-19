package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/3/23 21:54
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if(root==null){
            return false;
        }
        return hasPathSum(root,sum,0);

    }

    boolean hasPathSum(TreeNode root, int sum, int cur) {
        cur+=root.val;
        if(root.left==null&&root.right==null){
            return sum ==cur;
        }
        boolean hasLeft = false;
        if(root.left!=null){
            hasLeft = hasPathSum(root.left,sum,cur);
        }
        boolean hasRight = false;
        if(root.right!=null){
            hasRight = hasPathSum(root.right,sum,cur);
        }
        return hasLeft||hasRight;
    }
}
