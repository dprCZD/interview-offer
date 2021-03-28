package interview.bintree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/3/13 18:22
 */
public class ZigzagLevelOrder {


    /**
     * 之型层次遍历
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        stack.push(root);
        //表明当前层是否是反转层
        boolean reverse = false;
        while (!stack.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<>();
            ArrayList<TreeNode> nodes = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                nodes.add(node);
            }
            resList.add(res);

            for (TreeNode node : nodes) {
                //如果当前层是逆序层，则从右往左push；由于stack后进先出原理，下一层是必是正序。
                if (reverse) {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
                //如果当前层是正序层，则从左往右push；由于stack后进先出原理，下一层是必是逆序。
                else {
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            }
            reverse = !reverse;
        }
        return resList;


        // write code here
    }
}
