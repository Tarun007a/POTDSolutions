package Leetcode;

// Leetcode - 1320
// tc & sc - O(n * 27 * 27) -> O(n)
// class Solution {
//     private int[][][] dp;
//     private int getMinCost(int i, int finger1, int finger2, String word, int[][] cost) {
//         if(i == word.length()) return 0;
//         // System.out.println(i + " " + finger1 + " " + finger2);

//         int curr = (word.charAt(i) - 'A');

//         int cost1 = getMinCost(i+1, curr, finger2, word, cost);
//         int cost2 = getMinCost(i+1, finger1, curr, word, cost);

//         if(finger1 != -1) cost1 += cost[finger1][curr];

//         if(finger2 != -1) cost2 += cost[finger2][curr];

//         return Math.min(cost1, cost2);
//     }

//     public int minimumDistance(String word) {
//         int n = word.length();
//         int[][] cost = new int[26][26];
//         dp = new int[n][26][26];

//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < 26; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }

//         for(int i = 0; i < 26; i++) {
//             for(int j = 0; j < 26; j++) {
//                 int x1 = i / 6;
//                 int y1 = i % 6;

//                 int x2 = j / 6;
//                 int y2 = j % 6;

//                 cost[i][j] = Math.abs(x1-x2) + Math.abs(y1-y2);
//             }
//         }
//         return getMinCost(0, -1, -1, word, cost);
//     }
// }






class Solution {
    private int[][][] dp;
    private int getMinCost(int i, int finger1, int finger2, String word, int[][] cost) {
        if(i == word.length()) return 0;

        if(dp[i][finger1][finger2] != -1) return dp[i][finger1][finger2];

        int curr = (word.charAt(i) - 'A');

        int cost1 = getMinCost(i+1, curr, finger2, word, cost);
        int cost2 = getMinCost(i+1, finger1, curr, word, cost);

        if(finger1 != 26) cost1 += cost[finger1][curr];

        if(finger2 != 26) cost2 += cost[finger2][curr];

        return dp[i][finger1][finger2] = Math.min(cost1, cost2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][] cost = new int[26][26];
        dp = new int[n][27][27];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                int x1 = i / 6;
                int y1 = i % 6;

                int x2 = j / 6;
                int y2 = j % 6;

                cost[i][j] = Math.abs(x1-x2) + Math.abs(y1-y2);
            }
        }
        // for easy memo we will have 26 means nothing took till now
        return getMinCost(0, 26, 26, word, cost);
    }
}