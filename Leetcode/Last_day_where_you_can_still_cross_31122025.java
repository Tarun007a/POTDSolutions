package Leetcode;

// leetcode - 1970
// O(logk * (n+m+k), sc - O(n+m+k))  k is size of cells
class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private boolean isPossible(int idx, int n, int m, int[][] cells){
        int[][] grid = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];

        for(int[] row : grid) Arrays.fill(row, 0);

        for(int i = 0; i < idx; i++){
            int[] cell = cells[i];
            grid[cell[0]-1][cell[1]-1] = 1;
        }

        Queue<Pair> q = new ArrayDeque<>();
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int j = 0; j < m; j++){
            if(grid[0][j] == 0){
                isVisited[0][j] = true;
                q.add(new Pair(0, j));
            }
        }

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int row = curr.row;
            int col = curr.col;

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !isVisited[newRow][newCol] && grid[newRow][newCol] == 0){
                    if(newRow == n-1) return true;
                    isVisited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        int lo = 0;
        int hi = n;
        int result = 0;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isPossible(mid, row, col, cells)){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }
}
