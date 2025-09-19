package interview.string;

public class FinStr {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i =0;i<n;i++)
        {
            char cur = haystack.charAt(i);
            if(cur == needle.charAt(0))
            {
                int j =0;
                while(j<m && i+j <n && haystack.charAt(i +j) == needle.charAt(j))
                {
                    j++;
                }
                if(j == m)
                {
                    return i;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
