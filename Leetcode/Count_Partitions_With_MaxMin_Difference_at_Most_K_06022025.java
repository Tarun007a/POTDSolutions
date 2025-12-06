package Leetcode;

// leetcode - 3578
// tc - O(n). sc - O(n)
class Solution {
    public int countPartitions(int[] nums, int k) {
        int MOD = (int) 1e9 + 7;
        int n = nums.length;
        int left = 0;
        int[] dp = new int[n + 1];
        int[] prefix = new int[n + 2];

        dp[0] = 1;
        prefix[1] = 1;

        Deque<Integer> min = new ArrayDeque<>(), max = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
                max.pollLast();
            }
            max.addLast(i);

            while (!min.isEmpty() && nums[min.peekLast()] >= nums[i]) {
                min.pollLast();
            }
            min.addLast(i);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
                if (max.peekFirst() == left) max.pollFirst();
                if (min.peekFirst() == left) min.pollFirst();

                // the key thing is sometimes element at first of both the queue might not be
                // min or max but still k increases and someway ahead we will definatly
                // reach at k to remove some element and satisfy the condition
                left++;
            }

            dp[i + 1] = (prefix[i + 1] - prefix[left] + MOD) % MOD;

            prefix[i + 2] = (prefix[i + 1] + dp[i + 1]) % MOD;
        }

        return dp[n];
    }
}