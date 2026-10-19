package Leetcode;

// leetcode - 2089
// tc - O(nlogn)
// class Solution {
//     public List<Integer> targetIndices(int[] nums, int target) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         List<Integer> result = new ArrayList<>();

//         for(int i = 0; i < n; i++) {
//             if(nums[i] == target) result.add(i);
//         }
//         return result;
//     }
// }

// tc - O(n), sc - O(1)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        int smaller = 0;
        int freq = 0;
        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            if(num < target) smaller++;
            if(num == target) freq++;
        }

        for(int i = 0; i < freq; i++) {
            result.add(smaller + i);
        }
        return result;
    }
}
