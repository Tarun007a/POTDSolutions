package GFG;

// tc : O(4^(n*m)), sc - O(n*m)
// Also with the cell whcih we visited a new cell will never be visited again so
// we can say that we only have 3 options for each cell and hence tc - O(3^(n*m))
class Solution {
    int n, m;
    private int getLongestPath(int i, int j, int x, int y, int[][] mat, int[] delRow, int[] delCol, boolean[][] isVisited) {
        if(i == x && j == y) return 0;

        isVisited[i][j] = true;

        int curr = -1;

        for(int k = 0; k < 4; k++) {
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] != 0 &&  !isVisited[newRow][newCol]) {
                int len = getLongestPath(newRow, newCol, x, y, mat, delRow, delCol, isVisited);
                if(len != -1) curr = Math.max(curr, 1 + len);
            }
        }

        isVisited[i][j] = false;
        return curr;
    }

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        this.n = mat.length;
        this.m = mat[0].length;

        boolean[][] isVisited = new boolean[n][m];

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        return getLongestPath(xs, ys, xd, yd, mat, delRow, delCol, isVisited);
    }
}
