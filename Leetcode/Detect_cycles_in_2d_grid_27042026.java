package Leetcode;

// leetcode - 1559
// tc - o(n*m), sc - O(n*m)
class Solution {
    int[] delx = {0, 1, 0, -1};
    int[] dely = {1, 0, -1, 0};
    int n, m;

    private boolean isPossible(int row, int col, int prevRow, int prevCol, char ch, char[][] grid, boolean[][] isVisited, boolean[][] isProcessed) {
        isProcessed[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int newRow = row + delx[i];
            int newCol = col + dely[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == ch) {
                if(newRow != prevRow || newCol != prevCol) {
                    if(isVisited[newRow][newCol]) return true;

                    isVisited[newRow][newCol] = true;
                    if(!isProcessed[newRow][newCol] && isPossible(newRow, newCol, row, col, ch, grid, isVisited, isProcessed)) return true;
                    isVisited[newRow][newCol] = false;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] isProcessed = new boolean[n][m];
        boolean[][] isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                isVisited[i][j] = true;

                if(!isProcessed[i][j] && isPossible(i, j, -1, -1, grid[i][j], grid, isVisited, isProcessed)) return true;

                isVisited[i][j] = false;
                isProcessed[i][j] = true;
            }
        }
        return false;
    }
}