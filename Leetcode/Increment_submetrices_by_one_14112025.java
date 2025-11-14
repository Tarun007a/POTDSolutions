package Leetcode;

// leetcode - 2536
// tc - O(n*n), sc - O(n*n)
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];

        for(int[] query : queries){
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            result[row1][col1]++;
            if(col2+1 < n) result[row1][col2+1]--;
            if(row2+1 < n) result[row2+1][col1]--;
            if(row2+1 < n && col2+1 < n) result[row2+1][col2+1]++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                result[i][j] += result[i][j-1];
            }
        }

        for(int j = 0; j < n; j++){
            for(int i = 1; i < n; i++){
                result[i][j] += result[i-1][j];
            }
        }

        return result;
    }
}