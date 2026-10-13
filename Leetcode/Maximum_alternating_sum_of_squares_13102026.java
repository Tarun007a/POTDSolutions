package Leetcode;

// leetcode - 3727
// tc - O(nlogn), sc - O(n)
// class Solution {
//     public long maxAlternatingSum(int[] nums) {
//         int n = nums.length;
//         long result = 0;

//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(b) - Math.abs(a));

//         for(int num : nums) pq.add(num);

//         for(int i = 0; i < (n+1)/2; i++) {
//             int ele = pq.remove();
//             result += ele * ele;
//         }

//         while(!pq.isEmpty()) {
//             int ele = pq.remove();
//             result -= ele * ele;
//         }
//         return result;
//     }
// }

// tc - O(nlogn), sc - O(1)
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long result = 0;

        Arrays.sort(nums);
        int add = (n+1)/2;
        int subs = n - add;

        int i = 0;
        int j = n-1;

        while(i <= j) {
            if(add > 0) {
                add--;
                if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                    result += nums[i] * nums[i];
                    i++;
                }
                else {
                    result += nums[j] * nums[j];
                    j--;
                }
            }
            else {
                subs--;
                result -= nums[i] * nums[i];
                i++;
            }
        }

        return result;
    }
}