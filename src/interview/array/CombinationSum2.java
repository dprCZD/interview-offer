package interview.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: czd
 * @Description: 给出一组候选数 c 和一个目标数 t ，找出候选数中起来和等于 t 的所有组合。
 * <p>
 * c 中的每个数字在一个组合中只能使用一次。
 * @Date: 2022/4/5 22:35
 */
public class CombinationSum2 {


    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        dfs(num, target, new ArrayList<>(), res, 0);
        return res;
    }

    private void dfs(int[] nums, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            //> 相同数据跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] <= target) {
                cur.add(nums[i]);
                dfs(nums, target - nums[i], cur, res, i + 1);
                cur.remove(cur.size() - 1);
            } else {
                return;
            }
        }
    }
}
