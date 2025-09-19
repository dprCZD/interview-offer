package interview.string;

public class reverseWords {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty())
        {
            return null;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length()-1;
        while(left<s.length() && s.charAt(left) == ' ')
        {
            left++;
        }
        while(right>=0 &&s.charAt(right) == ' ')
        {
            right--;
        }
        boolean hasSpace = false;
        for(;right>=left;right--)
        {
            char c = s.charAt(right);
            if( c ==' ')
            {
                if(!hasSpace) {
                    sb.append(c);
                }
                hasSpace = true;
            }
            else
            {
                sb.append(c);
                hasSpace = false;
            }
        }

        int start = 0;
        n = sb.length();
        while(start<n)
        {
            int end = start;
            while(end < n && sb.charAt(end)!=' ')
            {
                end ++;
            }
            reverse(sb, start, end-1);
            start = end+1;
        }



        return sb.toString();
    }

    public void reverse(StringBuilder sb, int left, int right)
    {
        while(left<right)
        {
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new reverseWords().reverseWords("example   good a"));
    }
}
