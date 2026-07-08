package GFG;

// rc & sc - O(n+m)
class Solution {
    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int countCoordinates(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] pVisited = new boolean[n][m];
        boolean[][] qVisited = new boolean[n][m];

        Queue<Pair> pQueue = new LinkedList<>();
        Queue<Pair> qQueue = new LinkedList<>();

        for (int j = 0; j < m; j++) {
            if (!pVisited[0][j]) {
                pVisited[0][j] = true;
                pQueue.offer(new Pair(0, j));
            }
        }

        for (int i = 0; i < n; i++) {
            if (!pVisited[i][0]) {
                pVisited[i][0] = true;
                pQueue.offer(new Pair(i, 0));
            }
        }

        for (int j = 0; j < m; j++) {
            if (!qVisited[n - 1][j]) {
                qVisited[n - 1][j] = true;
                qQueue.offer(new Pair(n - 1, j));
            }
        }

        for (int i = 0; i < n; i++) {
            if (!qVisited[i][m - 1]) {
                qVisited[i][m - 1] = true;
                qQueue.offer(new Pair(i, m - 1));
            }
        }

        bfs(mat, pQueue, pVisited);
        bfs(mat, qQueue, qVisited);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pVisited[i][j] && qVisited[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] mat, Queue<Pair> queue, boolean[][] visited) {

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int n = mat.length;
        int m = mat[0].length;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            for (int k = 0; k < 4; k++) {

                int nr = curr.row + dr[k];
                int nc = curr.col + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && !visited[nr][nc]
                        && mat[nr][nc] >= mat[curr.row][curr.col]) {

                    visited[nr][nc] = true;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }
}