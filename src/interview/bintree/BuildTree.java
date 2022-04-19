package interview.bintree;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/10 20:37
 */
public class BuildTree {

    Map<Integer, Integer> inMap = new HashMap<>();


    public TreeNode buildTreeFromPreAndMid(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return subBuildTreeFromPreAndMid(preorder,0,preorder.length-1,0,inorder.length-1);

    }

    private TreeNode subBuildTreeFromPreAndMid(int[] preorder,  int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        //构造根节点
        TreeNode root = new TreeNode();
        root.val = preorder[preLeft];

        //获取中序遍历的根节点位置
        int inRootIndex = inMap.get(root.val);

        //获取左子树的大小
        int leftTreeSize = inRootIndex - inLeft;

        //遍历左侧子树
        // 先序遍历中「从 左边界+1 开始的 leftTreeSize」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = subBuildTreeFromPreAndMid(preorder, preLeft + 1, preLeft + leftTreeSize, inLeft, inRootIndex - 1);

        //遍历右侧子树
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = subBuildTreeFromPreAndMid(preorder, preLeft + leftTreeSize + 1, preRight, inRootIndex + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        int[] pre ={3,9,20,15,7};

        int[] in ={9,3,15,20,7};
        new BuildTree().buildTreeFromPreAndMid(pre,in);

    }
}
