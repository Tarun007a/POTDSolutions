package GFG;

// tc - O(n^3), sc - O(n^2)
class Solution {
    int[][] dp;
    private int getMin(int i, int j, int[] cuts){
        if(i+1 == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = 100000;
        for(int cut = i+1; cut < j; cut++){
            int curr = getMin(i, cut, cuts) + getMin(cut, j, cuts) + (cuts[j] - cuts[i]);
            min = Math.min(min, curr);
        }

        return dp[i][j] = min;
    }
    public int minCutCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m+2];

        arr[0] = 0;
        arr[m+1] = n;

        dp = new int[m+2][m+2];

        for(int i = 0; i < m+2; i++) Arrays.fill(dp[i], -1);

        for(int i = 0; i < m; i++) arr[i+1] = cuts[i];

        Arrays.sort(arr);

        return getMin(0, m+1, arr);
    }
}

