package Leetcodecontest.weekly488;

class Solution {
    long minValue = Long.MIN_VALUE;
    long nonVisited = Long.MIN_VALUE/2;
    int n;
    int m;
    long[][][] dp;

    public long helper(int i, int j, int k, int[] nums1, int[] nums2){
        if(k == 0) return 0;

        if(i == n || j == m) return minValue;

        if(dp[i][j][k] != nonVisited) return dp[i][j][k];

        long take = helper(i+1, j+1, k-1, nums1, nums2);
        if(take != minValue){
            take += (long)nums1[i] * (long)nums2[j];
        }

        long opt1 = helper(i+1, j, k, nums1, nums2);
        long opt2 = helper(i, j+1, k, nums1, nums2);

        return dp[i][j][k] = Math.max(take, Math.max(opt1, opt2));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        n = nums1.length;
        m = nums2.length;

        dp = new long[n][m][k+1];

        for(long[][] arr1 : dp){
            for(long[] arr2 : arr1) Arrays.fill(arr2, nonVisited);
        }
        long result = helper(0, 0, k, nums1, nums2);
        return result;
    }
}