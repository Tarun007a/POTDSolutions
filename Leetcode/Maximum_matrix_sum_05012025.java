package Leetcode;

// leetcode - 1975
// tc - O(n*m), sc - O(1)
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long ans = 0;
        int min = Integer.MAX_VALUE;
        boolean oddNegatives = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int num = matrix[i][j];

                if(num < 0)oddNegatives = !oddNegatives;
                min = Math.min(min, Math.abs(num));
                ans += (long)(Math.abs(num));
            }
        }

        if(oddNegatives)ans -= (long)(min*2);
        return ans;
    }
}