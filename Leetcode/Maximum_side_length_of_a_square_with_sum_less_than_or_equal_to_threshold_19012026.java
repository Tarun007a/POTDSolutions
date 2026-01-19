package Leetcode;

// leetcode - 1292
// tc - O(log(min(n,m)) * n * m), sc - O(n * m)
class Solution {
    private boolean checkSum(int i, int j, int k, int threshold, int[][] sum){
        int currSum = sum[i+k-1][j+k-1];

        if(i > 0) currSum -= sum[i-1][j+k-1];
        if(j > 0) currSum -= sum[i+k-1][j-1];
        if(i > 0 && j > 0) currSum += sum[i-1][j-1];

        return currSum <= threshold;
    }

    private boolean isPossible(int k, int threshold, int[][] sum){
        int n = sum.length;
        int m = sum[0].length;

        for(int i = 0; i < n-k+1; i++){
            for(int j = 0; j < m-k+1; j++){
                if(checkSum(i, j, k, threshold, sum)) return true;
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] sum = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum[i][j] = mat[i][j];
                if(j > 0) sum[i][j] += sum[i][j-1];
            }
        }

        for(int j = 0; j < m; j++){
            for(int i = 1; i < n; i++){
                sum[i][j] += sum[i-1][j];
            }
        }

        int lo = 1;
        int hi = Math.min(n, m);
        int result = 0;
        while(lo <= hi){
            int mid = lo - (lo - hi) / 2;
            if(isPossible(mid, threshold, sum)){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }
}


