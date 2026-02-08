package Leetcodecontest.weekly488;

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long result = 0;

        PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);

        int left = 0;
        for(int i = 0; i < n; i++){
            minPq.add(i);
            maxPq.add(i);

            long diff = (long)(nums[maxPq.peek()] - nums[minPq.peek()]);
            int size = i - left + 1;

            while(diff * (i - left + 1) > k){
                left++;
                while(minPq.peek() < left) minPq.remove();
                while(maxPq.peek() < left) maxPq.remove();

                diff = (long)(nums[maxPq.peek()] - nums[minPq.peek()]);
            }
            result += (long)(i - left + 1);
        }
        return result;
    }
}