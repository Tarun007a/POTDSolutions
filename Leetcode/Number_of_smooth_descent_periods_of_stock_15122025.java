package Leetcode;

// leetcode 2110
// tc - O(n), sc - O(1)


class Solution {
    public long getDescentPeriods(int[] prices) {
        
        int n = prices.length;
        long result = 0;
        int st = 0;

        for(int i = 1; i < n; i++){
            if(prices[i-1]-1 != prices[i]){
                long len = (long)(i-st);
                st = i;
                result += ((len)*(len+1))/2;
            }
        }
        long len = n-st;
        result += (long)((len)*(len+1))/2;
        return result;
    }
}
