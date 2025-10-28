package Leetcode;

// leetcode - 3354
// tc - O(n) sc - O(n)
// class Solution {
//     public int countValidSelections(int[] nums) {
//         int n = nums.length;
//         int[] suffixSum = new int[n];
//         int sum = 0;
//         int next = 0;
//         int result = 0;

//         for(int i = n-1; i >= 0; i--){
//             suffixSum[i] = nums[i] + next;
//             next = suffixSum[i];
//         }

//         for(int i = 0; i < n; i++){
//             if(nums[i] != 0){
//                 sum += nums[i];
//                 continue;
//             }
//             if(sum-suffixSum[i] == 0) result += 2;
//             else if(Math.abs(sum-suffixSum[i]) == 1) result++;
//         }
//         return result;
//     }
// }

// tc - O(n) sc - O(1)
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int total = 0;
        int curr = 0;
        int result = 0;

        for(int i : nums) total += i;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                curr += nums[i];
                continue;
            }
            if(2*curr - total == 0) result += 2;
            else if(Math.abs(2*curr - total) == 1) result++;
        }
        return result;
    }
}
