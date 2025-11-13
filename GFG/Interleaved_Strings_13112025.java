package GFG;

// tc - O(n*m), sc O(n*m)
class Solution {
    Boolean[][] dp;

    private boolean mixStr(int i, int j, String s1, String s2, String s3){
        if(i == 0 && j == 0) return true;

        if(dp[i][j] != null) return dp[i][j];

        int k = i + j - 1;

        boolean result = false;

        if(i > 0 && s1.charAt(i-1) == s3.charAt(k))
            result = result || mixStr(i-1, j, s1, s2, s3);

        if(j > 0 && s2.charAt(j-1) == s3.charAt(k))
            result = result || mixStr(i, j-1, s1, s2, s3);

        return dp[i][j] = result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int n = s1.length(), m = s2.length();
        dp = new Boolean[n+1][m+1];
        return mixStr(n, m, s1, s2, s3);
    }
}
