package Leetcode;

//tc - O(n*m), sc - O(n*m)
class Solution {
    int[][] dp;
    private int helper(int i, int j, String s1, String s2){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return helper(i-1, j-1, s1, s2) + s1.charAt(i);

        return dp[i][j] = Math.max(helper(i-1, j, s1, s2), helper(i, j-1, s1, s2));
    }

    private int getSum(String s){
        int result = 0;
        for(char ch : s.toCharArray()) result += ch;
        return result;
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n][m];

        for(int[] row : dp) Arrays.fill(row, -1);

        return getSum(s1) + getSum(s2) - 2*helper(n-1, m-1, s1, s2);
    }
}
