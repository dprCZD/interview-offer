package interview.hash;
import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums)
        {
            set.add(num);
        }

        int max = 0;
        for(int num:nums)
        {
            if(!set.contains(num-1))
            {
                int count = 1;
                while(set.contains(num+1))
                {
                    num++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;

    }
}
