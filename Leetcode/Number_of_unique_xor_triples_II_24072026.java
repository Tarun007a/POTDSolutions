package Leetcode;

// leetcode - 3514
// tc - O(n*n + n*m), sc - O(m)
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> unique = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                set.add(nums[i] ^ nums[j]);
            }
        }

        for(int xor : set) {
            for(int num : nums) {
                unique.add(xor ^ num);
            }
        }
        return unique.size();
    }
}