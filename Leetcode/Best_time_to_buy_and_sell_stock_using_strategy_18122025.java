package Leetcode;

// leetcode - 3652
// tc - O(n), sc - O(n)
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefixSum = new long[n];
        long[] profitSum = new long[n];
        long result = 0;

        profitSum[0] = strategy[0]*prices[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + prices[i];
            profitSum[i] = profitSum[i-1]+(strategy[i]*prices[i]);
            // System.out.println(prefixSum[i] + " " + profitSum[i]);
        }
        result = profitSum[n-1];

        for(int i = k-1; i < n; i++){
            int left = i-k;
            long sum = 0;

            if(left != -1) sum = profitSum[left];
            sum += profitSum[n-1] - profitSum[i];

            left = i-(k/2);
            sum += prefixSum[i] - prefixSum[left];

            result = Math.max(result, sum);
        }
        return result;
    }
}