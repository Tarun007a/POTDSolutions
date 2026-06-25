package GFG;

class Solution {

    int n;
    Boolean[][] dp;

    boolean dfs(int r, int c, int[][] mat, int[][] ans) {

        if (r >= n || c >= n || mat[r][c] == 0)
            return false;

        if (r == n - 1 && c == n - 1) {
            ans[r][c] = 1;
            return true;
        }

        if (dp[r][c] != null)
            return dp[r][c];

        ans[r][c] = 1;

        for (int jump = 1; jump <= mat[r][c]; jump++) {

            if (c + jump < n) {
                if (dfs(r, c + jump, mat, ans))
                    return dp[r][c] = true;
            }

            if (r + jump < n) {
                if (dfs(r + jump, c, mat, ans))
                    return dp[r][c] = true;
            }
        }

        ans[r][c] = 0;
        return dp[r][c] = false;
    }

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        n = mat.length;
        dp = new Boolean[n][n];

        int[][] ans = new int[n][n];

        if (!dfs(0, 0, mat, ans)) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(List.of(-1)));
            return res;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ans[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}