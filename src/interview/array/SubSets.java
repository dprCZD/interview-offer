package interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description:给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * @Date: 2022/4/13 21:37
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),res);
        return res;

    }

    private void dfs(int idx, int[]nums, List<Integer> cur , List<List<Integer>>res){
        if(idx ==nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        //> 深搜有当前位的场景
        cur.add(nums[idx]);
        dfs(idx+1,nums,cur,res);
        //> 深搜无当前位的场景
        cur.remove(cur.size()-1);
        dfs(idx+1,nums,cur,res);

    }

}
