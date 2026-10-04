package Leetcode;

// leetcode - 678
// tc & sc - O(n*n)
class Solution {
    int n;
    Boolean[][] dp;

    private boolean isValid(int i, int val, String s) {
        if(i == n) {
            if(val == 0) return true;
            return false;
        }

        if(val < 0) return false;

        if(dp[i][val] != null) return dp[i][val];

        if(s.charAt(i) == '(') return dp[i][val] = isValid(i+1, val+1, s);
        else if(s.charAt(i) == ')') return dp[i][val] = isValid(i+1, val-1, s);

        return dp[i][val] = (isValid(i+1, val+1, s) || isValid(i+1, val-1, s) ||
                isValid(i+1, val, s));
    }

    public boolean checkValidString(String s) {
        n = s.length();
        dp = new Boolean[n][n];

        return isValid(0, 0, s);
    }
}