package Leetcode;

// leetcode - 961
// tc - O(n), sc - O(1)
// all are unique so we have to find the char which get repeated
// here as the repeated number comes n/2 times exactaly we cannot use majority voting algo directly
// so store the first number and check if it repeates, then use majority voting algo from 1
class Solution {
    public int repeatedNTimes(int[] nums) {
        int first = nums[0];
        int ele = 0;
        int freq = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == first) return first;
            if(freq == 0){
                ele = nums[i];
            }
            if(nums[i] == ele) freq++;
            else freq--;
        }
        return ele;
    }
}