package Leetcode;

// leetcode - 3643
// tc - O(k*k), sc - O(1)
class Solution {
    private void reverse(int st, int end, int col, int[][] grid) {
        while(st < end) {
            int temp = grid[st][col];
            grid[st][col] = grid[end][col];
            grid[end][col] = temp;
            st++;
            end--;
        }
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int j = y; j < y+k; j++) {
            reverse(x, x+k-1, j, grid);
        }
        return grid;
    }
}