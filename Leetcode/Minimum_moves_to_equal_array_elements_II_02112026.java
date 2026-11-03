package Leetcode;

// leetcode - 426
// tc - O(nlogn), sc - O(1)
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        long aheadSum = 0;
        long prevSum = 0;
        long result = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int num : nums) aheadSum += num;

        for(int i = 0; i < n; i++) {
            long prevReq = (long)i * nums[i];
            long aheadReq = (long)(n - i) * nums[i];

            long curr = aheadSum - aheadReq + prevReq - prevSum;
            result = Math.min(result, curr);

            prevSum += nums[i];
            aheadSum -= nums[i];
        }
        return (int)result;
    }
}