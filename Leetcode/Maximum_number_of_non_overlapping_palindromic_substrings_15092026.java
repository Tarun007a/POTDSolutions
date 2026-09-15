package Leetcode;

// leetcode - 2472
// tc - O(n*n), sc - O(n*n)

class Solution {
    int n;
    int[][] dp;
    boolean[][] isPalindrome;

    private int helper(int i, int prev) {
        if(i == n) return 0;

        if(dp[i][prev] != -1) return dp[i][prev];

        int notSplit = helper(i+1, prev);

        int split = helper(i+1, i+1);

        if(isPalindrome[prev][i]) {
            split++;
        }

        return dp[i][prev] = Math.max(split, notSplit);
    }

    public int maxPalindromes(String s, int k) {
        n = s.length();
        isPalindrome = new boolean[n][n];
        dp = new int[n][n];

        for(int[] row : dp) Arrays.fill(row, -1);

        for(int i = 0; i < n; i++) {
            int st = i;
            int end = i;

            while(st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                if(end - st + 1 >= k) isPalindrome[st][end] = true;
                st--;
                end++;
            }

            st = i-1;
            end = i;

            while(st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                if(end - st + 1 >= k) isPalindrome[st][end] = true;
                st--;
                end++;
            }
        }
        return helper(0, 0);
    }
}


