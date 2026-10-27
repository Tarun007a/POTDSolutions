package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int[] dp;
    int n;

    private int helper(int i, String s) {
        if(i >= n) return 0;
        if(i == n-1) return 1;

        if(dp[i] != -1) return dp[i];

        int max = 1 + helper(i+1, s);

        if(s.charAt(i) == s.charAt(i+1)) {
            max = Math.max(max, 3 + helper(i+2, s));
        }
        else{
            max = Math.max(max, 4 + helper(i+2, s));
        }

        return dp[i] = max;
    }
    public int getMaxWeight(String s) {
        n = s.length();

        dp = new int[n];
        Arrays.fill(dp, -1);

        int result = helper(0, s);

        return result;
    }
}