package GFG;

// Stack overflow
// class Solution {
//     int[][] dp;
//     int mod = 1000000007;
//     private int getCount(int i, int rem, int n, String s) {
//         if(i == s.length()) return 0;

//         if(dp[i][rem] != -1) return dp[i][rem];

//         int num = s.charAt(i) - '0';

//         int newRem = rem*10 + num;
//         int take = getCount(i+1, newRem % n, n, s);
//         int notTake = getCount(i+1, rem, n, s);

//         return dp[i][rem] = ((newRem%n == 0 ? 1 : 0) + take + notTake) % mod;
//     }

//     public int countSubsequences(String s, int n) {
//         int m = s.length();

//         dp = new int[m][n];

//         for(int[] row : dp) Arrays.fill(row, -1);

//         return getCount(0, 0, n, s);
//     }
// }




// tc & sc - O(m*n)
class Solution {
    int[][] dp;
    int mod = 1000000007;
    private int getCount(int i, int rem, int n, String s) {
        if(i == s.length()) return 0;

        if(dp[i][rem] != -1) return dp[i][rem];

        int num = s.charAt(i) - '0';

        int newRem = rem*10 + num;
        int take = getCount(i+1, newRem % n, n, s);
        int notTake = getCount(i+1, rem, n, s);

        return dp[i][rem] = ((newRem%n == 0 ? 1 : 0) + take + notTake) % mod;
    }

    public int countSubsequences(String s, int n) {
        int m = s.length();

        int[][] dp = new int[m+1][n];

        Arrays.fill(dp[m], 0);

        for(int i = m-1; i >= 0; i--) {
            for(int r = 0; r < n; r++) {
                int num = s.charAt(i) - '0';

                int newRem = r*10 + num;
                int take = dp[i+1][newRem % n];
                int notTake = dp[i+1][r];

                dp[i][r] = ((newRem%n == 0 ? 1 : 0) + take + notTake) % mod;
            }
        }

        return dp[0][0];
    }
}


