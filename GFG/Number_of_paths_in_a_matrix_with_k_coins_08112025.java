package GFG;

class Solution {
    int[][][] dp;

    private int getWays(int i, int j, int n, int m, int k, int[][] mat){
        if(i == n || j == m || k < 0) return 0;
        if(i == n-1 && j == m-1 && mat[i][j] == k) return 1;

        if(dp[i][j][k] != -1) return dp[i][j][k];

        return dp[i][j][k] = getWays(i+1, j, n, m, k-mat[i][j], mat) + getWays(i, j+1, n, m, k-mat[i][j], mat);
    }

    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        dp = new int[n][m][k+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getWays(0, 0, n, m, k, mat);
    }
}