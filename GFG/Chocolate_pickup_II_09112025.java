package GFG;

// class Solution {
//     private int helper2(int i, int j, int[][] mat){
//         if(i == 0 && j == 0) return 0;

//         int chocolate = mat[i][j];
//         if(chocolate == -1) return -1;
//         int up = -1;
//         int left = -1;

//         mat[i][j] = 0;

//         if(i != 0) up = helper2(i-1, j, mat);
//         if(j != 0) left = helper2(i, j-1, mat);

//         mat[i][j] = chocolate;

//         if(up == -1 && left == -1) return -1;
//         return Math.max(up, left) + chocolate;
//     }

//     private int helper1(int i, int j, int[][] mat){
//         int n = mat.length;
//         if(i == n-1 && j == n-1){
//             return helper2(i, j, mat);
//         }

//         int chocolate = mat[i][j];
//         if(chocolate == -1) return -1;
//         int down = -1;
//         int right = -1;

//         mat[i][j] = 0;

//         if(i != n-1) down = helper1(i+1, j, mat);
//         if(j != n-1) right = helper1(i, j+1, mat);

//         mat[i][j] = chocolate;

//         if(down == -1 && right == -1) return -1;
//         return Math.max(right, down) + chocolate;
//     }
//     public int chocolatePickup(int[][] mat) {
//         int result = helper1(0, 0, mat);
//         if(result == -1) return 0;
//         return result;
//     }
// }


// tc - O(n^3), sc - O(n^3)
class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        Integer[][][] dp = new Integer[n][n][n];
        int ans = Math.max(0, dfs(mat, 0, 0, 0, dp));
        return ans;
    }

    private int dfs(int[][] mat, int i1, int j1, int i2, Integer[][][] dp) {
        int n = mat.length;
        int j2 = i1 + j1 - i2;

        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n || mat[i1][j1] == -1 || mat[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (i1 == n - 1 && j1 == n - 1) {
            return mat[i1][j1];
        }

        if (dp[i1][j1][i2] != null) return dp[i1][j1][i2];

        int val = mat[i1][j1];
        if (i1 != i2 || j1 != j2) {
            val += mat[i2][j2];
        }

        int max = Math.max(
                Math.max(dfs(mat, i1 + 1, j1, i2 + 1, dp), dfs(mat, i1, j1 + 1, i2, dp)),
                Math.max(dfs(mat, i1 + 1, j1, i2, dp), dfs(mat, i1, j1 + 1, i2 + 1, dp))
        );

        if (max == Integer.MIN_VALUE) return dp[i1][j1][i2] = Integer.MIN_VALUE;
        return dp[i1][j1][i2] = val + max;
    }
}