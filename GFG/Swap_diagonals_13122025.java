package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public void swapDiagonal(int[][] mat) {
        int n = mat.length;

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = n-1;

        for(int i = 0; i < n; i++){
            int temp = mat[x1][y1];
            mat[x1][y1] = mat[x2][y2];
            mat[x2][y2] = temp;
            x1++; y1++;
            x2++; y2--;
        }
    }
}