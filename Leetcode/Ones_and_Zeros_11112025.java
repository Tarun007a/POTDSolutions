package Leetcode;

// leetcode - 474
// tc - O(len*m*n), sc - O(len*m*n)
class Solution {
    class Pair{
        int zero;
        int one;
        public Pair(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }

    int[][][] dp;

    private int helper(int i, int m, int n, Pair[] pairs){
        if(i == pairs.length) return 0;

        if(dp[i][m][n] != -1) return dp[i][m][n];

        Pair pair = pairs[i];
        int take = 0;

        if(m >= pair.zero && n >= pair.one){
            take = 1 + helper(i+1, m-pair.zero, n-pair.one, pairs);
        }

        int notTake = helper(i+1, m, n, pairs);

        return dp[i][m][n] = Math.max(take, notTake);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Pair[] pairs = new Pair[len];

        dp = new int[len][m+1][n+1];

        for(int i = 0; i < len; i++){
            for(int j = 0; j <= m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i = 0; i < len; i++){
            int count = 0;
            int currLen = strs[i].length();
            for(char ch : strs[i].toCharArray()){
                if(ch == '0') count++;
            }
            pairs[i] = new Pair(count, currLen-count);
        }

        return helper(0, m, n, pairs);
    }
}