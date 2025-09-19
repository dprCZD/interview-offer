package interview.movewindow;

import java.util.ArrayList;
import java.util.*;

public class SubstringWithConcatenation {
    //1. 按每个offset分组
    //2. 通过滑动窗口计算diff，s在diff里对应的word+1，words在diff里对应的word-1，窗口单词数量==words.length，如果正好diff为空，说明正负抵消，可以匹配。
    //3. 最后尾巴要记得在判断一次。
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        List<Integer> result = new ArrayList<>();
        for(int offset = 0;offset<k;offset++)
        {
            List<String> splits = new ArrayList<>();
            for(int i =offset;i<n;i+=k)
            {
                int len = Math.min(i+k,n);
                splits.add(s.substring(i,len));
            }
            if(splits.size()<m)
            {
                return result;
            }

            Map<String, Integer> diff  = new HashMap<>();
            for(int i =0;i<m;i++)
            {
                String word = splits.get(i);
                diff.put(word,diff.getOrDefault(word,0)+1);
            }
            for (String word : words) {
                diff.put(word, diff.getOrDefault(word, 0) - 1);
                if (diff.get(word) == 0) {
                    diff.remove(word);
                }
            }

            int start = 0;
            int end = m;
            int length = splits.size();
            while(end < length)
            {
                if(diff.isEmpty())
                {
                    result.add(offset + start*k);
                }
                // move start
                String startWord = splits.get(start);
                int wordCount = diff.getOrDefault(startWord, 0);
                if(wordCount == 1)
                {
                    diff.remove(startWord);
                }
                else{
                    diff.put(startWord, wordCount-1);
                }
                start++;
                // move end
                String endWord =  splits.get(end);
                diff.put(endWord,diff.getOrDefault(endWord,0)+1);
                if(diff.get(endWord) == 0)
                {
                    diff.remove(endWord);
                }
                end++;
            }
            if(diff.isEmpty())
            {
                result.add(offset + start*k);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String[] words = {"fooo","barr","wing","ding","wing"};
        System.out.println(new SubstringWithConcatenation().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",words).toString());
    }
}
