package GFG;

// tc & sc - O(n*n)
class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int result = Integer.MIN_VALUE;

        int[][] cummSum = new int[n][n];

        for(int i = 0; i < n; i++) {
            cummSum[i][0] = mat[i][0];
            for(int j = 1; j < n; j++) {
                cummSum[i][j] = cummSum[i][j-1] + mat[i][j];
            }
        }

        for(int j = 0; j < n; j++) {
            for(int i = 1; i < n; i++) {
                cummSum[i][j] += cummSum[i-1][j];
            }
        }

        // for(int[] row : cummSum) System.out.println(Arrays.toString(row));

        for(int i = k-1; i < n; i++) {
            for(int j = k-1; j < n; j++) {
                int sum = cummSum[i][j];
                if(i-k >= 0) sum -= cummSum[i-k][j];
                if(j-k >= 0) sum -= cummSum[i][j-k];
                if(i-k >= 0 && j-k >= 0) sum += cummSum[i-k][j-k];

                // System.out.println(sum);

                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
