package GFG;

// tc - O(n), sc O(n)
class Solution {
    int[] dp;
    private int binarySearch(int lo, int end, int[][] jobs){
        int hi = jobs.length-1;
        int result = hi+1;

        while(lo <= hi){
            int mid = lo - (lo - hi)/2;
            if(jobs[mid][0] >= end){
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }

    private int maximize(int i, int[][] jobs){
        if(i == jobs.length) return 0;

        if(dp[i] != -1) return dp[i];

        int nextIdx = binarySearch(i+1, jobs[i][1], jobs);

        int take = maximize(nextIdx, jobs) + jobs[i][2];
        int notTake = maximize(i+1, jobs);

        return dp[i] = Math.max(take, notTake);
    }

    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        return maximize(0, jobs);
    }
}
