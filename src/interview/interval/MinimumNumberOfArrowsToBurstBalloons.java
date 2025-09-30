package interview.interval;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n<=1)
        {
            return n;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int count =1;
        int[] cur = points[0];

        for(int i =1;i<n;i++)
        {
            if(points[i][0]> cur[1])
            {
                cur = points[i];
                count++;
            }
            else
            {
                int L = Math.max(cur[0],points[i][0]);
                int R = Math.min(cur[1],points[i][1]);
                cur = new int[]{L,R};
            }
        }
        return count;

    }
}
