package Leetcode;

// leetcode - 835
// tc - O(n * m * n * m), sc - O(1)
class Solution {
    private int helper(int delRow, int delCol, int[][] img1, int[][] img2) {
        int n = img1.length;
        int m = img2.length;
        int overlap = 0;

        // System.out.println(delRow + " " + delCol);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int newRow = i + delRow;
                int newCol = j + delCol;

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < m) {
                    if(img1[i][j] == 1 && img2[newRow][newCol] == 1) overlap++;
                }
            }
        }
        return overlap;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int m = img2.length;
        int result = 0;

        for(int i = -n; i <= n; i++) {
            for(int j = -n; j <= m; j++) {
                int curr = helper(i, j, img1, img2);
                result = Math.max(curr, result);
            }
        }
        return result;
    }
}