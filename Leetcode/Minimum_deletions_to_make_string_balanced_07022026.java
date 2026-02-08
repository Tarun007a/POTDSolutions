package Leetcode;

// leetcode - 1653
// tc - O(n), sc - O(1)
// class Solution {
//     int[][] dp;
//     private int getMax(int i, char prev, String s){
//         if(i == s.length()) return 0;

//         if(dp[i][prev-'a'] != -1) return dp[i][prev-'a'];

//         if(s.charAt(i) == 'a'){
//             int curr = getMax(i+1, prev, s);
//             if(prev == 'a') return dp[i][prev-'a'] = 1 + curr;
//             return dp[i][prev-'a'] = curr;
//         }
//         else{
//             int take = 1 + getMax(i+1, 'b', s);
//             int notTake = getMax(i+1, prev, s);
//             return dp[i][prev-'a'] = Math.max(take, notTake);
//         }
//     }
//     public int minimumDeletions(String s) {
//         int n = s.length();
//         dp = new int[n][2];

//         for(int[] row : dp) row[0] = row[1] = -1;

//         return n - getMax(0, 'a', s);
//     }
// }

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] prev = new int[2];
        int[] curr = new int[2];

        prev[s.charAt(0)-'a']++;

        for(int i = 1; i < n; i++){
            if(s.charAt(i) == 'a'){
                curr[0] = prev[0] + 1;
                curr[1] = prev[1];
            }
            else{
                curr[0] = prev[0];
                curr[1] = Math.max(prev[1], prev[0]) + 1;
            }
            prev[0] = curr[0];
            prev[1] = curr[1];
        }
        return n - Math.max(prev[0], prev[1]);
    }
}