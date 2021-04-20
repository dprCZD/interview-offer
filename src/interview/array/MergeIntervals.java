package interview.array;

import java.util.*;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/17 21:38
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        //先进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curIntervals = intervals[i];
            int[] preIntervals = res.get(res.size()-1);

            //如果小于等于前置区间的右侧边界，则改变前置区间的右侧边界进行合并
            if (curIntervals[0] <= preIntervals[1]) {
                preIntervals[i] = Math.max(curIntervals[1], preIntervals[1]);
            }
            //否则是两个间隔的区间，新增到数组内。
            else {
                res.add(curIntervals);
            }
        }
        return  res.toArray(new int[res.size()][]);

    }
}
