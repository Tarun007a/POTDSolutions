package Leetcode;

// leetcode - 154
// tc - O(n), sc - O(1)

// First, perform a linear scan to skip initial values equal to the last element,
// since these values do not affect the search direction.
// Then, run the same lower-bound binary search to find the first element in the right section:

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int last = nums[n];
        int left = 0;
        int right = n;

        while (left < n && nums[left] == last) left++;

        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] > last) left = mid + 1;
            else right = mid;
        }

        return nums[left];
    }
}