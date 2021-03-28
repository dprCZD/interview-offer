package interview.bintree;

import model.TreeNode;

import java.util.*;

/**
 * @Author: czd
 * @Description: 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @Date: 2021/3/27 19:45
 */
public class RightSideView {

    /**
     * 广搜解法
     * 本质上时levelOrder。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            List<TreeNode> curLevel = new ArrayList<>();
            while (!stack.isEmpty()) {
                curLevel.add(stack.pop());
            }
            res.add(curLevel.get(curLevel.size() - 1).val);
            for (int i = curLevel.size() - 1; i >= 0; i--) {
                TreeNode curNode = curLevel.get(i);
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
            }
        }
        return res;

    }

    /**
     * 深搜递归解法
     * @param root
     * @return
     */
    Map<Integer,TreeNode> S=new HashMap<>();
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView3(TreeNode root) {
        getRightSide(0,root);
        return res;
    }
    void getRightSide(int h,TreeNode root)
    {
        if(root==null)
            return;
        if(!S.containsKey(h))
        {
            S.put(h,root);
            res.add(root.val);
        }
        h++;
        getRightSide(h,root.right);
        getRightSide(h,root.left);
    }

    /**
     * 深搜迭代版解法
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}
