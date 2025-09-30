package interview.movewindow;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<m;i++)
        {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        int resLen = Integer.MAX_VALUE;
        int resLeft = 0;
        int resRight = 0;
        while(right<=n)
        {
            if(!isValid(map))
            {
                if(right == n)
                {
                    break;
                }
                char cur = s.charAt(right);
                if(map.containsKey(cur))
                {
                    map.put(cur, map.get(cur)+1);
                }
                right++;
            }
            else
            {
                char cur = s.charAt(left);
                if(map.containsKey(cur)) {
                    int count = map.get(cur);
                    if (count == 0) {
                        if(resLen>(right-left))
                        {
                            resLeft = left;
                            resRight = right;
                            resLen = right-left;
                        }
                    }
                    map.put(cur, count - 1);
                }
                left++;
            }
        }
        return s.substring(resLeft,resRight);
    }
    private boolean isValid(Map<Character, Integer> map)
    {
        for(Integer cnt : map.values())
        {
            if(cnt<0)
            {
                return false;
            }
        }
        return true;
    }

}
