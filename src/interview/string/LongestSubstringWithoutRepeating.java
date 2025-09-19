package interview.string;
import java.util.*;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<>();

        while (end<n)
        {
            while(end<n && !charSet.contains(s.charAt(end)))
            {
                charSet.add(s.charAt(end));
                end++;
            }
            max = Math.max(max, end-start);
            charSet.remove(s.charAt(start));
            start++;
        }
        return max;
    }
}
