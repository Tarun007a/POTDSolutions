package Leetcode;

// leetcode - 3336
// tc - O(n * 200 * 200 * log(200)) where log 200 ~ 8
// tc - O(n * 4 * 10^4 * 8) -> O(n * 32 * 10^4)
// sc - O(n * 200 * 200)
class Solution {
    int[][][] dp;
    int mod = 1000_000_007;

    private static int gcd(int a, int b){
        while(b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int helper(int i, int seq1, int seq2, int[] nums) {
        if(i == nums.length) {
            if(seq1 == seq2) return 1;
            return 0;
        }

        if(dp[i][seq1][seq2] != -1) return dp[i][seq1][seq2];

        int total = 0;
        int num = nums[i];

        total = (total + helper(i+1, gcd(seq1, num), seq2, nums)) % mod;;
        total = (total + helper(i+1, seq1, gcd(seq2, num), nums)) % mod;
        total = (total + helper(i+1, seq1, seq2, nums)) % mod;

        return dp[i][seq1][seq2] = total;
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        dp = new int[n][201][201];

        for(int[][] a : dp) {
            for(int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return helper(0, 0, 0, nums) - 1;
    }
}
