package Leetcodecontest.weekly517;

class Solution {
    int n;
    int sum;

    int[][] dp;

    private int helper(int i, int curr, int[] nums) {
        // System.out.println(i + " " + curr);
        if(curr == sum) return 0;

        if(curr > sum || i == n) return -1;

        if(dp[i][curr] != -2) return dp[i][curr];

        int result = helper(i+1, curr, nums);

        int num = nums[i];
        int ops = 0;

        while(num <= sum) {
            int val = helper(i+1, curr + num, nums);

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

            if(num % 2 == 1 && num != 1) {
                int newNum = (num/2) * 2;
                int newOps = ops + 2;

                while(newNum <= sum) {
                    int newVal = helper(i+1, curr + newNum, nums);

                    if(newVal != -1) {
                        if(result == -1) result = newOps + newVal;
                        else result = Math.min(result, newOps + newVal);
                    }

                    newNum *= 2;
                    newOps++;
                }
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
