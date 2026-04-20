package Leetcode;

// leetcode - 2048
// tc - O(n*n), sc - O(1)
class Solution {
    private int getMaxDist(int idx, int[] colors) {
        int color = colors[idx];
        int j = colors.length-1;

        while(j > idx) {
            if(color != colors[j]) return j-idx;
            j--;
        }
        return 0;
    }
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int result = 0;

        for(int i = 0; i < n; i++) {
            result = Math.max(result, getMaxDist(i, colors));
        }
        return result;
    }
}