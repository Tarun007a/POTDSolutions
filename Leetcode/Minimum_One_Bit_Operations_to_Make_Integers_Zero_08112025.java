package Leetcode;

// leetcode - 1611
// tc - O(logn), sc-O(1)
class Solution {
    public int minimumOneBitOperations(int n) {
        int ans = n;
        while(n > 0) {
            n = n >> 1;
            ans ^= n;
        }
        return ans;
    }
}