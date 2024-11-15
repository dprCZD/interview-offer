package interview.dynamic;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for( int i = 0;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if( p.charAt(j-1) == '*'){
                    if(matches(s,p,i,j-1)){
                        // match 0 times: p[i][j-2], match n times: p[i-1][j]
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }
                    else
                    {
                        // no match equals match 0 times.
                       dp[i][j] = dp[i][j-2];
                    }
                }
                // dp[i][j] =dp[i-1][j-1] or false
                else
                {
                    dp[i][j] = matches(s,p, i, j)? dp[i-1][j-1]:false;
                }
            }
        }
        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j){
        if( i == 0){
            return false;
        }
        if(p.charAt(j-1) == '.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
