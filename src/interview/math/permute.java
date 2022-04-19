package interview.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/3/31 21:48
 */
public class permute {


        public List<List<Integer>> permute(int[] num) {

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            for(int v:num){
                cur.add(v);
            }
            permute(num,cur,res,0);
            return res;

        }


        private void permute(int[] nums, List<Integer>  cur, List<List<Integer>>  res, int first) {
            if (first == nums.length - 1) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = first; i < nums.length; i++) {
                Collections.swap(cur, first, i);
                permute(nums, cur, res, first + 1);
                Collections.swap(cur, first, i);
            }
    }
}
