package Leetcode;

// leetcode - 1727
// tc - n * mlogm, sc - O(n * m)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans = 0;
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 1) matrix[i][j]=matrix[i-1][j]+1;
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            Arrays.sort(matrix[i]);
            for(int j = matrix[0].length-1,k=1; j >= 0 && matrix[i][j] > 0; j--,k++){
                int s = k*matrix[i][j];
                ans = Math.max(ans,s);
            }
        }
        return ans;
    }
}