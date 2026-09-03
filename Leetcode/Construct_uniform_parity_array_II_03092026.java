package Leetcode;

// leetcode - 3876
// tc - O(n), sc - (1)
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int smallest = nums1[0];
        boolean allEven = true;

        for(int num : nums1) {
            smallest = Math.min(smallest, num);
            if(num%2 == 1) allEven = false;
        }

        if(allEven || smallest%2 == 1) return true;
        return false;
    }
}