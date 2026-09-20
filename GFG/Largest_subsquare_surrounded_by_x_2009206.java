package GFG;

// TC - O(n^3), sc - O(n^2)
class Solution {
    private int[][] up(char[][] mat) {
        int n = mat.length;
        int[][] result = new int[n][n];

        for(int j = 0; j < n; j++) result[n-1][j] = mat[n-1][j] == 'X' ? 1 : 0;

        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 'X') result[i][j] = 1 + result[i+1][j];
            }
        }

        return result;
    }

    private int[][] left(char[][] mat) {
        int n = mat.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++) result[i][n-1] = mat[i][n-1] == 'X' ? 1 : 0;

        for(int j = n-2; j >= 0; j--) {
            for(int i = 0; i < n; i++) {
                if(mat[i][j] == 'X') result[i][j] = 1 + result[i][j+1];
            }
        }

        return result;
    }

    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        int result = 0;
        int[][] downCount = up(mat);
        int[][] rightCount = left(mat);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n - Math.max(i, j); k++) {
                    int val1 = rightCount[i][j];
                    int val2 = downCount[i][j];
                    int val3 = rightCount[i+k][j];
                    int val4 = downCount[i][j+k];

                    if(val1 <= k || val2 <= k || val3 <= k || val4 <= k) continue;
                    result = Math.max(result, k+1);
                }
            }
        }

        return result;
    }
}
