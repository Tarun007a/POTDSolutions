package Leetcode;
// leetcode - 2257
// tc - O(n*m), sc - O(n*m)
class Solution {
    private void fillLeftToRight(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0; i < r; i++){
            boolean guarded = false;
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1)guarded = true;
                else if(grid[i][j] == -1)guarded = false;
                else if(guarded)grid[i][j] = 2;
            }
        }
    }

    private void fillTopToBottom(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        for(int j = 0; j < c; j++){
            boolean guarded = false;
            for(int i = 0; i < r; i++){
                if(grid[i][j] == 1)guarded = true;
                else if(grid[i][j] == -1)guarded = false;
                else if(guarded)grid[i][j] = 2;
            }
        }
    }

    private void fillRightToLeft(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0; i < r; i++){
            boolean guarded = false;
            for(int j = c-1; j >= 0; j--){
                if(grid[i][j] == 1)guarded = true;
                else if(grid[i][j] == -1)guarded = false;
                else if(guarded)grid[i][j] = 2;
            }
        }
    }

    private void fillBottomToTop(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        for(int j = 0; j < c; j++){
            boolean guarded = false;
            for(int i = r-1; i >= 0; i--){
                if(grid[i][j] == 1)guarded = true;
                else if(grid[i][j] == -1)guarded = false;
                else if(guarded)grid[i][j] = 2;
            }
        }
    }

    private int count(int[][] grid){
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j : grid[i]){
                if(j == 0)result++;
            }
        }
        return result;
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        //0 -> no guarded, -1 -> wall, 1 -> guard, 2-> guardedByGuard
        for(int i = 0; i < m; i++)Arrays.fill(grid[i], 0);

        for(int[] wall : walls){
            int r = wall[0];
            int c = wall[1];
            grid[r][c] = -1;
        }

        for(int[] guard : guards){
            int r = guard[0];
            int c = guard[1];
            grid[r][c] = 1;
        }

        fillLeftToRight(grid);
        fillTopToBottom(grid);
        fillRightToLeft(grid);
        fillBottomToTop(grid);

        return count(grid);
    }
}