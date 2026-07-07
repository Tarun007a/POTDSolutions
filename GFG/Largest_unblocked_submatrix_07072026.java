package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int bfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = 0;

        int[] delRow = {0, 1};
        int[] delCol = {1, 0};
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        grid[i][j] = 2;

        while(!q.isEmpty()) {
            Pair curr = q.remove();
            int row = curr.row;
            int col = curr.col;
            size++;

            for(int k = 0; k < 2; k++) {
                int newRow = row + delRow[k];
                int newCol = col + delCol[k];

                if(newRow >= 1 && newRow < n && newCol >= 1 && newCol < m &&
                        grid[newRow][newCol] == 0) {
                    // System.out.println(newRow + " " + newCol);
                    grid[newRow][newCol] = 2;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        return size;
    }

    public int largestArea(int n, int m, int k, int[][] arr) {
        int result = 0;
        int[][] grid = new int[n+1][m+1];
        boolean[] row = new boolean[n+1];
        boolean[] col = new boolean[m+1];

        for(int[] block : arr) {
            row[block[0]] = true;
            col[block[1]] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(row[i] || col[j]) grid[i][j] = 1;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(grid[i][j] == 0) {
                    result = Math.max(result, bfs(i, j, grid));
                }
            }
        }

        return result;
    }
}