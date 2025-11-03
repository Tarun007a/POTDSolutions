package Leetcode;

// leetcode - 1578
// tc - O(n), sc - O(1)
class Solution {
    public int minCost(String s, int[] arr) {
        int ans = 0;
        char[] carr = s.toCharArray();
        int currMax = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(carr[i] != carr[i-1]) currMax = arr[i];
            else{
                ans += Math.min(currMax,arr[i]);
                currMax = Math.max(currMax,arr[i]);
            }
        }
        return ans;
    }
}

