package Leetcode;

// leetcode - 3513
// tc - O(logn), sc - O(1)
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int bits = 0;

        while(n != 0) {
            bits++;
            n /= 2;
        }

        return (int)Math.pow(2, bits);
    }
}