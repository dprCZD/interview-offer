package interview.hash;

import java.util.*;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n =magazine.length();
        if(m>n) {
            return false;
        }
        int[] chars = new int[26];
        for( int i=0;i<magazine.length();i++) {
            chars[magazine.charAt(i)-'a']++;
        }
        for(int i =0;i<ransomNote.length();i++) {
            int cur = ransomNote.charAt(i)-'a';
            if(chars[cur] == 0)
            {
                return false;
            }
            chars[cur]--;
        }
        return true;
    }
}
