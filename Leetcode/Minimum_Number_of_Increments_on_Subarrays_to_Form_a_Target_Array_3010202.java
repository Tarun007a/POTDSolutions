package Leetcode;

// leetcode - 1526
// tc - O(n), sc - O(1)
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int result = 0;
        int prev = 0;

        for(int i : target){
            if(i > prev) result += (i-prev);
            prev = i;
        }
        return result;
    }
}