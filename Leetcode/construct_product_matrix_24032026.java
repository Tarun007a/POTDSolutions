package Leetcode;

// leetcode - 2906
// tc - O(n * m), sc - O(n * m)
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int[][] result = new int[n][m];


        int[][] suffixArr = new int[n][m];
        long suffix = 1;
        long prefix = 1;

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                suffix = (suffix * grid[i][j])%mod;
                suffixArr[i][j] = (int)suffix;
            }
        }

        suffix = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j != m-1) suffix = suffixArr[i][j+1];
                else if(i != n-1) suffix = suffixArr[i+1][0];
                else suffix = 1;

                result[i][j] = (int)((prefix * suffix) % mod);
                prefix = (grid[i][j] * prefix) % mod;
            }
        }
        return result;
    }
}