package Leetcode;

// leetcode - 3718
// tc & sc - O(n)
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        int curr = k;
        while(set.contains(curr)) curr += k;
        return curr;
    }
}
