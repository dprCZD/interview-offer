package interview.interval;

import java.util.*;
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            int startDiff = o1[0]-o2[0];
            return startDiff == 0? o1[1]- o2[1] : startDiff;
        });
        List<int[]> resultList = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i = 1;i<intervals.length;i++)
        {
            if(cur[1] >= intervals[i][1])
            {
                continue;
            }
            if(cur[1]>=intervals[i][0])
            {
                cur[1] = intervals[i][1];
            }
            else
            {
                resultList.add(cur);
                cur = intervals[i];
            }
        }
        resultList.add(cur);
        return resultList.toArray(new int[resultList.size()][2]);

    }
}
