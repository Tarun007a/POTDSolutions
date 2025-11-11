package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    private static int[][] dp;

    private static int helper(int i, int j, String s1, String s2){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(i-1, j-1, s1, s2) + 1;
        }

        return dp[i][j] = Math.max(helper(i-1, j, s1, s2), helper(i, j-1, s1, s2));
    }

    public static int minSuperSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        dp = new int[n][m];
        for(int[] a : dp) Arrays.fill(a, -1);

        return n + m - helper(n-1, m-1, s1, s2);
    }
}