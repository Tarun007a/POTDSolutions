package Leetcodecontest.weekly517;

class Solution {
    int sum;
    int n;
    int[][] dp;

    private int helper(int i, int curr, int[] nums) {
        // System.out.println(curr);
        if(curr == sum) return 0;
        if(i == n || curr > sum) return -1;

        if(dp[i][curr] != -2) return dp[i][curr];

        int result = helper(i+1, curr, nums);

        int num = nums[i];
        int ops = 0;

        while(num <= sum) {
            int val = helper(i+1, curr+num, nums);

            if(val != -1) {
                if(result == -1) result = ops + val;
                else result = Math.min(result, ops + val);
            }

            num *= 2;
            ops++;
        }


        num = nums[i];
        ops = 0;

        while(num > 0) {
            int val = helper(i+1, curr+num, nums);

            if(val != -1) {
                if(result == -1) result = ops + val;
                else result = Math.min(result, ops + val);
            }

            num /= 2;
            ops++;
        }
        return dp[i][curr] = result;
    }

    public int minOperations(int[] nums, int sum) {
        this.n = nums.length;
        this.sum = sum;

        dp = new int[n][sum+1];

        for(int[] row : dp) Arrays.fill(row, -2);

        return helper(0, 0, nums);
    }
}
