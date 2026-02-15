package Leetcodecontest.weekly489;

// TLE
// I knew this wont work, failed on 1014th testcase out of 1015
class Solution {
    private int getMax(int st, int end, int[] cummXor){
        int result = 0;
        for(int i = st; i <= end; i++){
            if(i == 0) result = cummXor[end];
            else result = Math.max(result, cummXor[end] ^ cummXor[i-1]);
        }
        return result;
    }

    public int maxXor(int[] nums, int k) {
        int n = nums.length;
        int[] cummXor = new int[n];
        int result = 0;
        int st = 0;
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);

        for(int i = 0; i < n; i++){
            if(i == 0) cummXor[i] = nums[i];
            else cummXor[i] = nums[i] ^ cummXor[i-1];

            minPq.add(i);
            maxPq.add(i);

            while(nums[maxPq.peek()] - nums[minPq.peek()] > k){
                st++;
                while(maxPq.peek() < st) maxPq.remove();
                while(minPq.peek() < st) minPq.remove();
            }

            result = Math.max(result, getMax(st, i, cummXor));
        }
        return result;
    }
}
