package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:已知两颗二叉树，将它们合并成一颗二叉树。合并规则是： 都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * @Date: 2022/3/26 22:40
 */

public class MergeTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // write code here
        if(root1 == null){
            return  root2;
        }
        if(root2 == null){
            return  root1;
        }
        root1.val=root1.val+root2.val;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        return root1;
    }
}
