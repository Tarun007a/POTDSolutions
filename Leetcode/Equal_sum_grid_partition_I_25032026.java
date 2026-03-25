package Leetcode;

// leetcode - 3546
// tc - O(n * m), sc - O(n * m)
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] sum = new long[n][m];

        for(int i = 0; i < n; i++){
            sum[i][0] = (long)(grid[i][0]);
            for(int j = 1; j < m; j++){
                sum[i][j] = (long)(grid[i][j] + sum[i][j-1]);
            }
        }

        for(int j = 0; j < m; j++){
            for(int i = 1; i < n; i++){
                sum[i][j] += (long)sum[i-1][j];
            }
        }

        for(int i = 0; i < n; i++){
            long curr = sum[i][m-1];
            if(curr*2 == sum[n-1][m-1])return true;
        }

        for(int j = 0; j < m; j++){
            long curr = sum[n-1][j];
            if(curr*2 == sum[n-1][m-1])return true;
        }
        return false;
    }
}
