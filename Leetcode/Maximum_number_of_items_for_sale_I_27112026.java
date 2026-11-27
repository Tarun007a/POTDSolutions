package Leetcode;

// leetcode - 3946
// tc & sc - O(n * budget)

// put the min cost in last and take as many of copies as you can, no need to
// check for number of copies for each element
class Solution {
    int[][] dp;

    private int helper(int i, int budget, int[] freeCopies, int[][] items) {
        int n = items.length;

        if(i == n) return 0;

        if(i == n-1) {
            int copies = budget / items[i][1];

            if(copies == 0) return 0;

            return copies + freeCopies[i];
        }

        if(dp[i][budget] != -1) return dp[i][budget];

        int notTake = helper(i+1, budget, freeCopies, items);

        int take = 0;

        if(budget >= items[i][1]) {
            take = helper(i+1, budget - items[i][1], freeCopies, items) + 1 + freeCopies[i];
        }

        return dp[i][budget] = Math.max(take, notTake);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        dp = new int[n][budget + 1];
        int[] freeCopies = new int[n];

        int minIdx = 0;

        for(int i = 0; i < n; i++) {
            if(items[i][1] < items[minIdx][1]) minIdx = i;
        }

        int factor = items[minIdx][0];
        int price = items[minIdx][1];

        items[minIdx][0] = items[n-1][0];
        items[minIdx][1] = items[n-1][1];

        items[n-1][0] = factor;
        items[n-1][1] = price;

        for(int[] arr : dp) Arrays.fill(arr, -1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                if(items[j][0] % items[i][0] == 0) freeCopies[i]++;
            }
        }

        return helper(0, budget, freeCopies, items);
    }
}