package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/1/31 19:43
 */
public class LowestCommonAncestor {


    /**
     * 递归查左右节点，如果左节点没有则返回右节点，如果右节点没有则返回左节点。如果都有说明当前值为公共祖先，返回。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        if(root==null){
            return -1;
        }
        if(root.val==p||root.val==q){
            return root.val;
        }
        int left =lowestCommonAncestor(root.left,p,q);
        int right=lowestCommonAncestor(root.right,p,q);
        if(left==-1){
            return right;
        }
        if(right==-1){
            return left;
        }
        return root.val;
    }
}
