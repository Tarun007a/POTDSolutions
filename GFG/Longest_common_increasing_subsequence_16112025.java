package GFG;

// state dp[i][j], for i in a and j is prev took index in b so we maintain both the codition
// of increasing and also order that if we take idx x then we cannot take anything less that
// x
// tc - O(n*m), tc - O(n*m)
class Solution {
    int[][] dp;

    private int dfs(int[] a, int[] b, int i, int j) {
        if (i == a.length) return 0;

        if (dp[i][j + 1] != -1) return dp[i][j + 1];

        int best = dfs(a, b, i + 1, j);

        for (int k = j + 1; k < b.length; k++) {
            if (b[k] == a[i]) {
                if (j == -1 || b[k] > b[j]) {
                    best = Math.max(best, 1 + dfs(a, b, i + 1, k));
                }
                break;
            }
        }

        return dp[i][j + 1] = best;
    }

    public int LCIS(int[] a, int[] b) {
        dp = new int[a.length][b.length + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(a, b, 0, -1);
    }
}

