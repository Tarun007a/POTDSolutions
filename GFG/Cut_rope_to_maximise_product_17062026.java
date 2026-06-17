// tc - O(n), sc - O(n)
class Solution {
    int[] dp;

    private int getMax(int n) {
        if(n <= 4) return n;

        if(dp[n] != -1) return dp[n];

        int currMax = n;
        for(int i = 1; i <= n/2; i++) {
            currMax = Math.max(currMax, getMax(i) * getMax(n-i));
        }
        return dp[n] = currMax;
    }

    public int maxProduct(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getMax(n);
    }
}