package Leetcode;

// rec + memo
// tc - O(n * m * m) -> TLE
// class Solution {
//     int MOD = 1_000_000_007;
//     int N, M;
//     int[][][] t;

//     private int solve(int i, int prevVal, boolean increasing) {
//         if (i == N) return 1;

//         int dir = increasing ? 1 : 0;
//         if (t[i][prevVal][dir] != -1) {
//             return t[i][prevVal][dir];
//         }

//         int result = 0;
//         if (increasing) {
//             for (int nextVal = prevVal + 1; nextVal <= M; nextVal++) {
//                 result = (result + solve(i + 1, nextVal, false)) % MOD;
//             }
//         }
//         else {
//             for (int nextVal = 1; nextVal < prevVal; nextVal++) {
//                 result = (result + solve(i + 1, nextVal, true)) % MOD;
//             }
//         }

//         return t[i][prevVal][dir] = result;
//     }

//     public int zigZagArrays(int n, int l, int r) {
//         N = n;
//         M = r - l + 1;
//         t = new int[N + 1][M + 1][2];
//         for (int[][] a : t) {
//             for (int[] b : a) Arrays.fill(b, -1);
//         }

//         long result = 0;
//         for (int startVal = 1; startVal <= M; startVal++) {
//             result = (result + solve(1, startVal, true)) % MOD;
//             result = (result + solve(1, startVal, false)) % MOD;
//         }
//         return (int) result;
//     }
// }


// bottom up
// tc - O(n * m * m) -> TLE
// class Solution {
//     public int zigZagArrays(int n, int l, int r) {
//         int m = r - l + 1;
//         int mod = 1000_000_007;
//         long result = 0;
//         int[][][] dp = new int[n+1][m+1][2];

//         for(int prevVal = 1; prevVal <= m; prevVal++) {
//             dp[n][prevVal][0] = dp[n][prevVal][1] = 1;
//         }

//         for(int i = n-1; i >= 0; i--) {
//             for(int prevVal = 1; prevVal <= m; prevVal++) {
//                 for(int nextVal = prevVal+1; nextVal <= m; nextVal++) {
//                     dp[i][prevVal][1] = (dp[i][prevVal][1] + dp[i+1][nextVal][0]) % mod;
//                 }

//                 for(int nextVal = 1; nextVal < prevVal; nextVal++) {
//                     dp[i][prevVal][0] = (dp[i][prevVal][0] + dp[i+1][nextVal][1]) % mod;
//                 }
//             }
//         }

//         for (int startVal = 1; startVal <= m; startVal++) {
//             result = (result + dp[1][startVal][0]) % mod;
//             result = (result + dp[1][startVal][1]) % mod;
//         }
//         return (int) result;
//     }
// }

// these two inner loop
// for(int nextVal = prevVal+1; nextVal <= m; nextVal++) {
//     dp[i][prevVal][1] = (dp[i][prevVal][1] + dp[i+1][nextVal][0]) % mod;
// }

// for(int nextVal = 1; nextVal < prevVal; nextVal++) {
//      dp[i][prevVal][0] = (dp[i][prevVal][0] + dp[i+1][nextVal][1]) % mod;
// }

// consider the first once whcih goes from prevVal+1 to <= m and we calculte
// dp[i+1][prevVal+1][0] + dp[i+1][prevVal+2][0] + dp[i+1][prevVal+3][0] ...
// so here i+1, and 0 is fixed and prevVal is cummulative sum from prevVal+1 to m
// we will be using prefix sum to remove the for loop and then
// prefixSum[m] - prefixSum[prevVal] this will give us the required sum of
// prevVal+1 to m, now we will fill the prefixSum array when we are on the i+1
// iteration, and then similarly for the next loop where i+1 and 1 are fixed
// parameters so a diffrent prefix sum for the 0 i.e. decreasing one

// tc - O(n * m), sc - O(n * m + m)
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int mod = 1000_000_007;
        long result = 0;
        int[][][] dp = new int[n+1][m+1][2];

        long[] prefixSumInc = new long[m+1];
        long[] prefixSumDec = new long[m+1];

        for(int prevVal = 1; prevVal <= m; prevVal++) {
            dp[n][prevVal][0] = dp[n][prevVal][1] = 1;
        }

        for(int j = 1; j <= m; j++) {
            prefixSumInc[j] = prefixSumInc[j-1] + dp[n][j][1];
            prefixSumDec[j] = prefixSumDec[j-1] + dp[n][j][0];
        }

        for(int i = n-1; i >= 0; i--) {
            for(int prevVal = 1; prevVal <= m; prevVal++) {
                // for(int nextVal = prevVal+1; nextVal <= m; nextVal++) {
                //     dp[i][prevVal][1] = (dp[i][prevVal][1] + dp[i+1][nextVal][0]) % mod;
                // }

                dp[i][prevVal][1] = (int)((prefixSumDec[m] - prefixSumDec[prevVal] + mod) % mod);

                // for(int nextVal = 1; nextVal < prevVal; nextVal++) {
                //     dp[i][prevVal][0] = (dp[i][prevVal][0] + dp[i+1][nextVal][1]) % mod;
                // }

                dp[i][prevVal][0] = (int)(prefixSumInc[prevVal-1] % mod);
            }

            for(int j = 1; j <= m; j++) {
                prefixSumInc[j] = (prefixSumInc[j-1] + dp[i][j][1]) % mod;
                prefixSumDec[j] = (prefixSumDec[j-1] + dp[i][j][0]) % mod;
            }
        }

        for (int startVal = 1; startVal <= m; startVal++) {
            result = (result + dp[1][startVal][0]) % mod;
            result = (result + dp[1][startVal][1]) % mod;
        }
        return (int) result;
    }
}
