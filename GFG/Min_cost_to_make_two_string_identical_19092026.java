package GFG;

// TLE
// class Solution {
//     int[][] dp;

//     private int getCost(int i, int j, int cost1, int cost2, String s1, String s2) {
//         if(i == s1.length()) return (s2.length() - j) * cost2;
//         if(j == s2.length()) return (s1.length() - i) * cost1;

//         if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = getCost(i+1, j+1, cost1, cost2, s1, s2);

//         return dp[i][j] = Math.min(getCost(i+1, j, cost1, cost2, s1, s2) + cost1,
//                         getCost(i, j+1, cost1, cost2, s1, s2) + cost2);
//     }

//     public int findMinCost(String s1, String s2, int costS1, int costS2) {
//         int n = s1.length();
//         int m = s2.length();

//         dp = new int[n][m];

//         for(int[] row : dp) Arrays.fill(row, -1);

//         return getCost(0, 0, costS1, costS2, s1, s2);
//     }
// }





// tc & sc - O(n * m)
class Solution {

    public int findMinCost(String s1, String s2, int cost1, int cost2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i < n ;i++) dp[i][m] = (n - i) * cost1;
        for(int j = 0; j < m; j++) dp[n][j] = (m - j) * cost2;
        dp[n][m] = 0;

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1];

                else dp[i][j] = Math.min(dp[i+1][j] + cost1, dp[i][j+1] + cost2);
            }
        }

        return dp[0][0];
    }
}
