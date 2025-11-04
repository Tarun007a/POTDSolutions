package GFG;

// tc - O(n), sc - O(1)
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        if(n == 1) return 0;

        int pp = 0;
        int prev = Math.abs(height[0]-height[1]);

        for(int i = 2; i < n; i++){
            int h = height[i];
            int cost1 = Math.abs(h - height[i-1]) + prev;

            int cost2 = Math.abs(h - height[i-2]) + pp;


            pp = prev;
            prev = Math.min(cost1, cost2);
        }
        return prev;
    }
}