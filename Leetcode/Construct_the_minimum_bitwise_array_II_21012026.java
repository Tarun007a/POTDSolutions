package Leetcode;

// leetcode - 3315
// tc - O(nlogn), sc - O(1)
// take any bitwise number let 11010111 and then add 1 to this, then take OR
// and then try to observe whats happening.

class Solution {
    private int getMin(int num){
        if((num & 1) == 0) return -1;

        int temp = 1;

        while((temp & num) != 0){
            temp = temp << 1;
        }

        // now to make prev bit zero we have two ways and, xor one

        temp = temp >> 1;

        // using and
        // temp = ~temp;
        // return temp & num;

        // using xor
        return temp^num;
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
