package Leetcode;

// leetcode - 115
// tc & sc - O(n * m)
class Solution {
    int n, m;
    int[][] dp;

    private int count(int i, int j, String s, String t) {
        if(j == m) return 1;
        if(i == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int take = 0;
        if(s.charAt(i) == t.charAt(j)) take = count(i+1, j+1, s, t);

        int notTake = count(i+1, j, s, t);

        return dp[i][j] = take + notTake;
    }

    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();

        dp = new int[n][m];

        for(int[] row : dp) Arrays.fill(row, -1);

        return count(0, 0, s, t);
    }
}
