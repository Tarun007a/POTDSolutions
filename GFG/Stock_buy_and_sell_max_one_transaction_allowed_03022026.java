package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        int currMin = prices[0];

        for(int i = 1; i < n; i++){
            result = Math.max(result, prices[i] - currMin);
            currMin = Math.min(currMin, prices[i]);
        }
        return result;
    }
}
