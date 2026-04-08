package Leetcode;

// leetcode - 3653
// tc - O(n*n), sc - O(1)
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long mod = 1000000007;
        int xor = 0;

        for(int[] q : queries){
            for(int i = q[0]; i <= q[1]; i += q[2]){
                nums[i] = (int)(((long)nums[i] * (long)q[3]) % mod);
            }
        }

        for(int i : nums) xor = xor ^ i;
        return xor;
    }
}
