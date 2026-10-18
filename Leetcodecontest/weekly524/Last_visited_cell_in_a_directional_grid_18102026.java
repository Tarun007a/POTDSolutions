package Leetcodecontest.weekly524;

class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row = 0;
        int col = 0;
        boolean[][] isVisited = new boolean[n][m];
        isVisited[0][0] = true;

        while(true) {
            int newRow = row;
            int newCol = col;
            if(grid[row][col] == 'R') {
                newCol = col+1;
            }
            else if(grid[row][col] == 'D') {
                newRow = row+1;
            }
            else if(grid[row][col] == 'L') {
                newCol = col-1;
            }
            else {
                newRow = row-1;
            }

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !isVisited[newRow][newCol]) {
                row = newRow;
                col = newCol;
                isVisited[row][col] = true;
            }
            else {
                return new int[]{row, col};
            }
        }
    }
}