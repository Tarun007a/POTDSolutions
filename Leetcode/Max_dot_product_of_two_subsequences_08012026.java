package Leetcode;

// leetcode - 1458
// tc - O(n*m), sc - O(n*m)
// standard lcs
class Solution {
    int singleMax;
    int[][] dp;
    static int min = Integer.MIN_VALUE;
    private int helper(int i, int j, int[] nums1, int[] nums2){
        if(i == nums1.length || j == nums2.length) return 0;

        if(dp[i][j] != min) return dp[i][j];

        singleMax = Math.max(singleMax, nums1[i]*nums2[j]);

        int max = helper(i+1, j+1, nums1, nums2) + nums1[i]*nums2[j];
        max = Math.max(max, helper(i+1, j, nums1, nums2));
        max = Math.max(max, helper(i, j+1, nums1, nums2));

        return dp[i][j] = max;
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, min);
        }
        singleMax = nums1[0] * nums2[0];

        int result = helper(0, 0, nums1, nums2);
        if(result == 0) return singleMax;

        return result;
    }
}