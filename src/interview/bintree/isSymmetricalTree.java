package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/10 20:49
 */
public class isSymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);

    }

    private boolean isSymmetrical(TreeNode rl, TreeNode rr) {
        //> 如果都为空，说明遍历到底
        if (rl == null && rr == null) {
            return true;
        }
        //> 如果其中一个不为空，说明不对称
        if (rl == null || rr == null) {
            return false;
        }
        //> 如果值不相等，说明不对称
        if (rl.val != rr.val) {
            return false;
        }
        //> 遍历子树,rl先左后右，rr先右后左。
        return isSymmetrical(rl.left, rr.right) && isSymmetrical(rl.right, rr.left);
    }
}
