package Leetcode;

// leetcode - 3550
// tc - O(nlogn)
class Solution {
    private int get(int n){
        int sum = 0;
        while(n != 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i == get(nums[i]))return i;
        }
        return -1;
    }
}