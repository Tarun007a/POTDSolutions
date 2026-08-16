package GFG;

// tc - O(n), sc - O(n)
class Solution {
    class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    int n;
    Pair[][] dp;

    private Pair helper(int i, boolean took, int[] arr) {
        if(i == n) return new Pair(1, 1);

        if(i == n-1 && !took) return new Pair(arr[i], arr[i]);

        if(dp[i][took ? 0 : 1] != null) return dp[i][took ? 0 : 1];

        Pair take = helper(i+1, true, arr);

        Pair notTake = helper(i+1, took, arr);

        if(arr[i] >= 1) {
            take = new Pair(take.min * arr[i], take.max * arr[i]);
        }
        else {
            take = new Pair(take.max * arr[i], take.min * arr[i]);
        }

        return dp[i][took ? 0 : 1] = new Pair(Math.min(take.min, notTake.min), Math.max(take.max, notTake.max));
    }

    public int minProd(int[] arr) {
        this.n = arr.length;
        dp = new Pair[n][2];
        return helper(0, false, arr).min;
    }
}