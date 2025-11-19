package GFG;

// tc - O(n*m * log(n*m)), sc - O(n*m)
class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});

        int[] delRow = {1, -1, 0, 0};
        int[] delCol = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if (row == n - 1 && col == m - 1) return cost;

            if (cost > dist[row][col]) continue;

            for (int k = 0; k < 4; k++) {
                int newRow = row + delRow[k];
                int newCol = col + delCol[k];

                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;

                int edgeCost = Math.abs(mat[row][col] - mat[newRow][newCol]);
                int newCost = Math.max(cost, edgeCost);

                if (newCost < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newCost;
                    pq.add(new int[]{newRow, newCol, newCost});
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
