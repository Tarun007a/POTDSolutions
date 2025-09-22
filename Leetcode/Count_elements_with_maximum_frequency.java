package Leetcode;
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int max = -1;
        int[] freq = new int[101];
        for(int i = 0; i < n; i++){
            freq[nums[i]]++;
            max = Math.max(freq[nums[i]],max);
        }
        int ans = 0;
        for(int i = 0; i <= 100; i++){
            if(freq[i] == max)ans += freq[i];
        }
        return ans;
    }
}
