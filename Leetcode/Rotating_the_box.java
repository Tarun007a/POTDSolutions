package Leetcode;

// leetcode - 1861
// tc - O(n*m), sc - O(m)
class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        char[][] result = new char[m][n];
        int resultCol = 0;

        for(int i = n-1; i >= 0; i--) {
            int[] prefixSum = new int[m];
            int prev = 0;
            int kept = 0;

            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '#') prefixSum[j] = ++prev;
                else if(grid[i][j] == '.') prefixSum[j] = prev;
                else prefixSum[j] = prev = 0;
            }

            // System.out.println(Arrays.toString(prefixSum));

            int curr = prefixSum[m-1];
            for(int j = m-1; j >= 0; j--) {
                if(grid[i][j] == '*') {
                    result[j][resultCol] = '*';
                    kept = 0;
                    if(j != 0) curr = prefixSum[j-1];
                }
                else if(curr - kept > 0) {
                    result[j][resultCol] = '#';
                    kept++;
                }
                else result[j][resultCol] = '.';
            }
            resultCol++;
        }
        return result;
    }
}