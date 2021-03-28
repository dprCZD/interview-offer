package interview.bintree;

import model.TreeNode;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/3/13 18:55
 */
public class MirrorBinTree {

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return pRoot;
        }
        TreeNode temp =pRoot.left;
        pRoot.left=pRoot.right;
        pRoot.right=temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
