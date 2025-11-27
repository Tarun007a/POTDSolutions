package Leetcode;

// leetcode - 3381
// tc - O(n), sc - O(n)
class Solution {
    private long helper(int i, List<Long> list , int jump){
        int n = list.size();
        long currSum = 0;
        long max = list.get(0);

        for(; i < n; i += jump){
            currSum += list.get(i);
            max = Math.max(max, currSum);
            if(currSum < 0)currSum = 0;
        }
        return max;
    }
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        long currSum = 0;

        long max = Long.MIN_VALUE;

        List<Long> list = new ArrayList<>();

        for(int i = 0; i < k ;i++){
            currSum += (long)(nums[i]);
        }
        int idx = 0;

        list.add(currSum);
        for(int i = k; i < n; i++){
            currSum += (long)(nums[i]);
            currSum -= (long)(nums[idx]);
            idx++;
            list.add(currSum);
        }

        for(int i = 0; i < k; i++){
            max = Math.max(max, helper(i, list, k));
        }
        return max;
    }
}