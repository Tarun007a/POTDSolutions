package GFG;

// tc & sc -o(x)
class Solution {
    int s, m, l;
    int cs, cm, cl;
    int[] dp;

    private int helper(int x) {
        if(x <= 0) return 0;

        if(dp[x] != -1) return dp[x];

        int currS = helper(x-s) + cs;
        int currM = helper(x-m) + cm;
        int currL = helper(x-l) + cl;

        return dp[x] = Math.min(currS, Math.min(currM, currL));
    }

    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        this.s = s;
        this.m = m;
        this.l = l;
        this.cs = cs;
        this.cm = cm;
        this.cl = cl;

        dp = new int[x+1];
        Arrays.fill(dp, -1);

        return helper(x);
    }
}