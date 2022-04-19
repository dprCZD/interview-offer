package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:已知两颗二叉树，将它们合并成一颗二叉树。合并规则是： 都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * @Date: 2022/3/26 22:40
 */

public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
