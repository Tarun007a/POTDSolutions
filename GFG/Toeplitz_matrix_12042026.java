package GFG;

// tc - O(n*m), sc - O(1)
class Solution {
    private boolean check(int i, int j, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ele = mat[i][j];

        while(i < n && j < m) {
            if(mat[i++][j++] != ele) return false;
        }
        return true;
    }

    public boolean isToeplitz(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++) {
            if(!check(i, 0, mat)) return false;
        }
        for(int i = 1; i < m; i++) {
            if(!check(0, i, mat)) return false;
        }
        return true;
    }
}