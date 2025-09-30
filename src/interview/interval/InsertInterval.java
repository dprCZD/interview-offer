package interview.interval;

import java.util.*;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();

        int left = newInterval[0];
        int right = newInterval[1];

        boolean inserted = false;
        for(int i =0;i<n;i++)
        {
            if(intervals[i][1]<newInterval[0]) {
                merged.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1])
            {
                if(!inserted)
                {
                    merged.add(new int[]{left,right});
                    inserted = true;
                }
                merged.add(intervals[i]);
            }
            else
            {
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
            }
        }
        if(!inserted)
        {
            merged.add(new int[]{left,right});
        }

        return merged.toArray(new int[merged.size()][2]);

    }
}
