package Leetcode;

// leetcode - 1886
// tc - O(n*m), sc - O(n*m)
class Solution {
    private int[][] rotate (int[][] mat) {
        int n = mat.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[j][n-i-1] = mat[i][j];
            }
        }
        return result;
    }

    private boolean check(int[][] mat, int[][] target) {
        int n = mat.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i < 4; i++) {
            mat = rotate(mat);
            if(check(mat, target)) return true;
        }
        return false;
    }
}
