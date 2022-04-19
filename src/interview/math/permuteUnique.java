package interview.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/4/1 20:45
 */
public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;

    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] vis) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //> 如果有连续两个一样的或者访问过，则跳过。
            if (vis[i] || i > 0 && nums[i - 1] == nums[i] && vis[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            vis[i] = true;
            permute(nums, res, cur, vis);
            vis[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
