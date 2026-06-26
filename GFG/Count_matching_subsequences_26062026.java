package GFG;

// tc - O(n*m), sc - O(n*m)
// class Solution {
//     private static int n, m;
//     private static final int MOD = 1000_000_007;
//     private static int[][] dp;

//     private static int getCount(int i, int j, String s1, String s2) {
//         if(j == m) return 1;
//         if(i == n) return 0;

//         if(dp[i][j] != -1) return dp[i][j];

//         int curr = 0;
//         curr = getCount(i+1, j, s1, s2);

//         if(s1.charAt(i) == s2.charAt(j)) {
//             curr += getCount(i+1, j+1, s1, s2);
//         }

//         return dp[i][j] = curr % MOD;
//     }

//     public static int countWays(String s1, String s2) {
//         n = s1.length();
//         m = s2.length();

//         dp = new int[n][m];

//         for(int[] a : dp) Arrays.fill(a, -1);

//         return getCount(0, 0, s1, s2);
//     }
// }




// tc - O(n*m), sc - O(n*m)
// class Solution {
//     public static int countWays(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();

//         int MOD = 1000_000_007;

//         int[][] dp = new int[n+1][m+1];

//         for(int j = 0; j <= m; j++) dp[n][j] = 0;
//         for(int i = 0; i <= n; i++) dp[i][m] = 1;

//         for(int i = n-1; i >= 0; i--) {
//             for(int j = m-1; j >= 0; j--) {
//                 int curr = dp[i+1][j];

//                 if(s1.charAt(i) == s2.charAt(j)) {
//                     curr += dp[i+1][j+1];
//                 }
//                 dp[i][j] = curr % MOD;
//             }
//         }

//         return dp[0][0];
//     }
// }




// tc - O(n*m), sc - O(m)
class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int MOD = 1000_000_007;

        int[] curr = new int[m+1];
        int[] next = new int[m+1];
        next[m] = 1;

        for(int i = n-1; i >= 0; i--) {
            curr[m] = 1;
            for(int j = m-1; j >= 0; j--) {
                int count = next[j];

                if(s1.charAt(i) == s2.charAt(j)) {
                    count += next[j+1];
                }
                curr[j] = count % MOD;
            }
            int[] temp = curr;
            curr = next;
            next = temp;
        }

        return next[0];
    }
}


