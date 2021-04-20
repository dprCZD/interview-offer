package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/18 21:00
 */
public class MaxDepth {
    int max = 0;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        subPathSum(root,1);
        return max;
    }

    private void subPathSum(TreeNode root, int sum) {
        //递归出口
        if (root.left == null && root.right == null) {
            max = Math.max(sum, max);
        }
        if (root.left != null) {
            subPathSum(root.left, sum+1);
        }
        if (root.right != null) {
            subPathSum(root.right, sum+1);
        }

    }
}
