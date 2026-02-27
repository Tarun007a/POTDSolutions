package GFG;

// tc - O(n*m*Math.min(n,m)), sc - O(1)
class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                mat[i][j] += mat[i][j-1];
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] += mat[i-1][j];
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 1; (i+k-1) < n && (j+k-1) < m; k++){
                    int total = mat[i+k-1][j+k-1];
                    if(i > 0) total -= mat[i-1][j+k-1];
                    if(j > 0) total -= mat[i+k-1][j-1];
                    if(i > 0 && j > 0) total += mat[i-1][j-1];

                    if(total == x) count++;
                }
            }
        }
        return count;
    }
}