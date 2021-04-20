package interview.bintree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/18 21:11
 */
public class DFS {


    /**
     * 中序遍历-递归版
     */
    List<Integer> inorder =new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return inorder;
        }
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
        return inorder;
    }

    /**
     * 中序遍历-迭代版
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> inorder =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root !=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root= stack.pop();
            inorder.add(root.val);
            root=root.right;
        }
        return  inorder;
    }

    /**
     * 后序遍历-迭代版
     * 增加了一个prev前置节点记录上个节点访问的结果，如果上个节点访问结果是当前节点的右子树，则说明当前节点左右子树以及访问完毕，可以访问当前节点。
     */
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> postorder =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev =null;
        while(root !=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root= stack.pop();
            //如果当前根节点的右节点为空或者是上个遍历的节点，则添加当前根节点。
            if(root.right == null ||root.right ==prev){
                postorder.add(root.val);
                prev =root;
                root = null;

            }
            //否则遍历当前根节点的右子树。
            else {
                stack.push(root);
                root=root.right;
            }
     }
        return  postorder;
    }

    /**
     * 前序遍历-迭代版
     */
    public List<Integer> postorderTraversallIteration(TreeNode root) {
        List<Integer> preorder =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root !=null||!stack.isEmpty()){
            while(root!=null){
                preorder.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop().right;
        }
        return  preorder;
    }
}
