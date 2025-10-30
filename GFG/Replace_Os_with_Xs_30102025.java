package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    private class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0; i < n; i++){
            if(grid[i][0] == 'O') q.add(new Pair(i, 0));
            if(grid[i][m-1] == 'O') q.add(new Pair(i, m-1));
        }

        for(int j = 1; j < m-1; j++){
            if(grid[0][j] == 'O') q.add(new Pair(0, j));
            if(grid[n-1][j] == 'O') q.add(new Pair(n-1, j));
        }

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int row = curr.row;
            int col = curr.col;

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 'O' && !isVisited[newRow][newCol]){
                    isVisited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }

        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                if(grid[i][j] == 'O' && !isVisited[i][j]) grid[i][j] = 'X';
            }
        }
    }
}
