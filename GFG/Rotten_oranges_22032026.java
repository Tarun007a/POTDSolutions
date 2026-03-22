package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    private class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int result = 0;

        Queue<Pair> q = new ArrayDeque<>();
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 2) q.add(new Pair(i, j, 0));
            }
        }

        while(!q.isEmpty()) {
            Pair curr = q.remove();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;

            for(int del = 0; del < 4; del++) {
                int newRow = row + delRow[del];
                int newCol = col + delCol[del];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && mat[newRow][newCol] == 1) {
                    mat[newRow][newCol] = 2;
                    q.add(new Pair(newRow, newCol, time+1));
                    result = Math.max(result, time+1);
                }
            }
        }

        for(int[] oranges : mat) {
            for(int orange : oranges) {
                if(orange == 1) return -1;
            }
        }
        return result;
    }
}
