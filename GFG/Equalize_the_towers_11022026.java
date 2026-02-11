package GFG;

// tc - O(n * log(max(heights))), sc - O(1)
class Solution {
    public int calculateCost(int[] heights, int[] costs, int h) {
        int n = costs.length;
        int curr = 0;
        for(int i = 0; i < n; i++) {
            curr += Math.abs(heights[i] - h) * costs[i];
        }
        return curr;
    }

    public int minCost(int[] heights, int[] cost) {
        int low = Arrays.stream(heights).min().getAsInt();
        int high = Arrays.stream(heights).max().getAsInt();

        while(low <= high) {
            int mid = low - (low - high) / 2;

            int left = calculateCost(heights, cost, mid - 1);
            int val = calculateCost(heights, cost, mid);
            int right = calculateCost(heights, cost, mid + 1);

            if(val <= left && val <= right) return val;
            else if(left >= val && val >= right) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
