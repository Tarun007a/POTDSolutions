package Leetcode;

// leetcode - 3619
// tc - O(n*m), sc - O(n*m)
class Solution {
    int[] delRow = {-1, 0, +1, 0};
    int[] delCol = {0, +1, 0, -1};

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private long getSumOfIsland(int row, int col, int[][] grid, boolean[][] isVisited) {
        int n = grid.length;
        int m = grid[0].length;
        long sum = grid[row][col];

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        isVisited[row][col] = true;

        while(!q.isEmpty()) {
            Pair p = q.remove();

            for(int i = 0; i < 4; i++) {
                int newRow = p.row + delRow[i];
                int newCol = p.col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol < m && newCol >= 0 && !isVisited[newRow][newCol] && grid[newRow][newCol] != 0) {
                    isVisited[newRow][newCol] = true;
                    sum += grid[newRow][newCol];
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!isVisited[i][j] && grid[i][j] != 0) {
                    long sum = getSumOfIsland(i, j, grid, isVisited);
                    if(sum % k == 0) result++;
                }
            }
        }
        return result;
    }
}