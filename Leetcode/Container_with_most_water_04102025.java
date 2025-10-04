package Leetcode;

// leetcode 11
// time - O(n)

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lo = 0;
        int hi = n-1;
        int max = 0;

        while(lo < hi){
            int curr = (hi-lo) * Math.min(height[lo], height[hi]);
            max = Math.max(max, curr);
            if(height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }
}