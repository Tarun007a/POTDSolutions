package Leetcode;

// leetcode - 3314
// tc - O(n * m), sc - O(1)
class Solution {
    private int getMin(int ele){
        for(int i = 0; i < ele; i++){
            if((i | (i+1)) == ele) return i;
        }
        return -1;
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            result[i] = getMin(nums.get(i));
        }
        return result;
    }
}