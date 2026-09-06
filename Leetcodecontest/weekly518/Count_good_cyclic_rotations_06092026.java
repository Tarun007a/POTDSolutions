package Leetcodecontest.weekly518;

class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int result = 0;
        int m = n/2;

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        long sum = prefixSum[n-1];

        for(int i = 0; i < n-m+1; i++) {
            long first = prefixSum[i+m-1];
            if(i > 0) first -= prefixSum[i-1];

            // System.out.println(first);

            long second = sum - first;
            if(first > second) result++;
        }

        for(int i = 0; i < m-1; i++) {
            long first = sum - prefixSum[n-m+i];
            first += prefixSum[i];

            // System.out.println(first);

            long second = sum - first;

            if(first > second) result++;
        }
        return result;
    }
}