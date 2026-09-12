package GFG;

// tc & sc - O(n * k)
class Solution {
    Pair[][] dp;

    class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private Pair helper(int i, int k, int[] arr) {
        if (k == 0) return new Pair(1, 1);

        if (i == arr.length || arr.length - i < k) return null;

        if(dp[i][k] != null) return dp[i][k];

        Pair p1 = helper(i + 1, k, arr);

        Pair p2 = helper(i + 1, k - 1, arr);

        int takeMax = Math.max(p2.max * arr[i], p2.min * arr[i]);

        int takeMin = Math.min(p2.max * arr[i], p2.min * arr[i]);

        p2 = new Pair(takeMin, takeMax);

        if (p1 == null) return dp[i][k] = p2;

        return dp[i][k] = new Pair(Math.min(p1.min, p2.min),
                Math.max(p1.max, p2.max));
    }

    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        dp = new Pair[n][k+1];
        return helper(0, k, arr).max;
    }
}