package interview.string;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1)
        {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for( int i=0;i<numRows;i++)
        {
            boolean switcher = true;
            int j =i;
            while(j<n)
            {
                sb.append(s.charAt(j));
                if((switcher || i ==0) && i != numRows -1)
                {
                    j = j + 2*(numRows -1 -i);
                    switcher = false;
                    continue;
                }
                j = j + 2*i;
                switcher = true;

            }
        }
        return sb.toString();
    }
}
