package Leetcode;

// leetcode - 2996
// tc - O(n), sc - O(n)
class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int i = 1;
        int sum = nums[0];
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);

        while(i < n && nums[i] == nums[i-1]+1) {
            sum += nums[i];
            set.add(nums[i]);
            i++;
        }

        while(i < n) {
            set.add(nums[i]);
            i++;
        }

        while(true) {
            if(!set.contains(sum)) return sum;
            sum++;
        }
    }
}