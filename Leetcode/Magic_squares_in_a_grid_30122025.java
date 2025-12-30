package Leetcode;

// leetcode 840
// tc - O(n*m), sc - O(1)
class Solution {
    private boolean isDistinct(int row, int col, int[][] grid){
        HashSet<Integer> set = new HashSet<>();
        for(int i = row; i < row+3; i++){
            for(int j = col; j < col+3; j++){
                if(grid[i][j] > 9 || grid[i][j] == 0) return false;
                set.add(grid[i][j]);
            }
        }
        return set.size() == 9;
    }

    private boolean isMagic(int i, int j, int[][] grid){
        int row1 = 0;
        int row2 = 0;
        int col1 = 0;
        int col2 = 0;
        int dia1 = 0;
        int dia2 = 0;

        if(!isDistinct(i, j, grid)) return false;

        for(int r = i; r < i+3; r++){
            col1 += grid[r][j];
            col2 += grid[r][j+2];
        }

        for(int c = j; c < j+3; c++){
            row1 += grid[i][c];
            row2 += grid[i+2][c];
        }

        for(int k = 0; k < 3; k++) dia1 += grid[i+k][j+k];

        for(int k = 0; k < 3; k++) dia2 += grid[i+k][j+2-k];

        if(row1 != row2 || row1 != col1 || row1 != col2 || row1 != dia1 || row1 != dia2) return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;

        for(int i = 0; i <= n-3; i++){
            for(int j = 0; j <= m-3; j++){
                if(isMagic(i, j, grid)) result++;
            }
        }
        return result;
    }
}
