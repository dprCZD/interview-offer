package interview.bintree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 *
 * 核心思想是中序遍历。
 * @Date: 2022/4/9 23:03
 */
public class KthNodeInBinTree {

    //> 递归版本
    int res = -1;
    int index = 0;

    public int KthNode(TreeNode proot, int k) {
        if (proot == null || k <= 0) {
            return -1;
        }
        KthNode(proot.left, k);
        index++;
        if (index == k) {
            return res = proot.val;
        }
        KthNode(proot.right, k);
        return res;
    }

    //> 迭代版本
    public int KthNode2(TreeNode proot, int k) {
        if (k <= 0 || proot == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = proot;
        int index = 0;
        while (cur != null||!stack.isEmpty()) {
            //> 遍历左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            index++;
            if(index == k){
                return cur.val;
            }
            cur =cur.right;
        }
        return -1;
    }
}
