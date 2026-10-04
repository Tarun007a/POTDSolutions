package GFG;

// tc - O(n*m), sc - O(1)
class Solution {
    static int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int result = 0;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    for(int k = 0; k < 4; k++) {
                        int newRow = i + delRow[k];
                        int newCol = j + delCol[k];

                        if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) result++;
                        else if (mat[newRow][newCol] == 0) result++;
                    }
                }
            }
        }
        return result;
    }
}
