package interview.bintree;

import model.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/1/17 16:37
 */
public class BFS {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue =new LinkedList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<TreeNode> levelNodes=new ArrayList<>();
            while(!queue.isEmpty()){
                levelNodes.add(queue.remove());
            }
            res.add((ArrayList)levelNodes.stream().map(k -> k.val).collect(Collectors.toList()));
            for(TreeNode curLevel:levelNodes){
                if(curLevel.left!=null){
                    queue.offer(curLevel.left);
                }
                if(curLevel.right!=null){
                    queue.offer(curLevel.right);
                }
            }

        }
        return res;
    }
}

