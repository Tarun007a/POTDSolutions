package GFG;

// tc - O(n * m), sc - O(n * m)
class Solution {
    class Pair {
        int row;
        int col;
        int cost;

        public Pair(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        int[][] arr = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int[] row : arr) Arrays.fill(row, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    arr[i][j] = 0;

                    for(int k = 0; k < 4; k++) {
                        int newRow = i + delRow[k];
                        int newCol = j + delCol[k];

                        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                            arr[newRow][newCol] = 0;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(arr[i][0] == 1) {
                q.add(new Pair(i, 0, 1));
                isVisited[i][0] = true;
            }
        }

        while(!q.isEmpty()) {
            Pair curr = q.remove();

            if(curr.col == m-1) return curr.cost;

            for(int k = 0; k < 4; k++) {
                int newRow = curr.row + delRow[k];
                int newCol = curr.col + delCol[k];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        arr[newRow][newCol] == 1 && !isVisited[newRow][newCol]) {
                    q.add(new Pair(newRow, newCol, curr.cost + 1));
                    isVisited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}
