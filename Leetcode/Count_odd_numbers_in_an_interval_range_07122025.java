package Leetcode;

// leetcode - 1523
// tc - O(1), sc - O(1)
class Solution {
    public int countOdds(int low, int high) {
        return low%2 == 0 ? (high-low+1)/2 : (high-low+2)/2;
    }
}
