package Leetcode;

// leetcode - 1351
// tc - O(n+m), sc - O(1)
class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        int col = m-1;

        for(int row = 0; row < n; row++){
            if(grid[row][m-1] < 0){
                while(col >= 0 && grid[row][col] < 0) col--;
                result += m - ++col;
            }
        }
        return result;
    }
}
