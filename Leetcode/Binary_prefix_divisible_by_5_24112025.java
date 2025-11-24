package Leetcode;

// leetcode 1018
// tc - O(n), sc - O(1)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        int num = 0;
        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            num = num << 1;
            if(nums[i] == 1)num++;
            num = num%5;
            result.add(num == 0);
        }
        return result;
    }
}
