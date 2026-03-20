package Leetcode;

// leetcode - 3070
// tc - O(n*m), sc - O(1)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            int curr = 0;
            for(int j = 0; j < m; j++){
                curr += grid[i][j];
                grid[i][j] = curr;
            }
        }
        int ans = 0;
        for(int j = 0; j < m; j++){
            int curr = 0;
            for(int i = 0; i < n; i++){
                curr += grid[i][j];
                grid[i][j] = curr;
                if(curr <= k)ans++;
            }
        }
        return ans;
    }
}