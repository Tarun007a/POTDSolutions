package GFG;

class Solution {
    public int minCost(int[][] cost) {
        int n = cost.length;
        int k = cost[0].length;

        if (n == 1) return Arrays.stream(cost[0]).min().getAsInt();
        if (k == 1) return -1;

        int[] prev = new int[k];

        for (int j = 0; j < k; j++) {
            prev[j] = cost[0][j];
        }

        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int idx1 = -1;

            for (int j = 0; j < k; j++) {
                int val = prev[j];
                if (val < min1) {
                    min2 = min1;
                    min1 = val;
                    idx1 = j;
                } else if (val < min2) {
                    min2 = val;
                }
            }

            int[] curr = new int[k];

            for (int j = 0; j < k; j++) {
                int bestPrev = (j == idx1) ? min2 : min1;
                curr[j] = bestPrev + cost[i][j];
            }

            prev = curr;
        }

        return Arrays.stream(prev).min().getAsInt();
    }
}