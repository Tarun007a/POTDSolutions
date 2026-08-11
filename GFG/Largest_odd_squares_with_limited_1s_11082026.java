package GFG;

// tc - O(n*m + q*log(max(n,m))), sc - O(n*m)
class Solution {
    private boolean isPossible(int radius, int row, int col,
                               int[][] prefix, int k) {

        int n = prefix.length - 1;
        int m = prefix[0].length - 1;

        int top = row - radius;
        int bottom = row + radius;
        int left = col - radius;
        int right = col + radius;

        if (top < 0 || bottom >= n || left < 0 || right >= m) {
            return false;
        }

        int sum = prefix[bottom + 1][right + 1]
                - prefix[top][right + 1]
                - prefix[bottom + 1][left]
                + prefix[top][left];

        return sum <= k;
    }

    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {

            int row = query[0];
            int col = query[1];

            int maxRadius = Math.min(
                    Math.min(row, n - 1 - row),
                    Math.min(col, m - 1 - col)
            );

            int lo = 0;
            int hi = maxRadius;

            int best = -1;

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;

                if (isPossible(mid, row, col, prefix, k)) {
                    best = mid;
                    lo = mid + 1;
                }
                else hi = mid - 1;
            }

            if (best == -1) result.add(-1);
            else result.add(2 * best + 1);
        }

        return result;
    }
}