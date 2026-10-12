package Leetcode;

// Editorial approach - Only when a bit in a is 1 and the corresponding bit in b is 0 does
// the operation move the 1 from a to b, effectively swapping the values of that
// bit.
// 1 bits can only move from the first element to the second. Therefore, the
// first element can only decrease or stay the same, while the second can only
// increase or stay the same.
// The total number of 1 bits at each binary position remains unchanged, so the
// sum of all elements also remains unchanged, we can just transfer bits so we
// strategy is to make large numbers as large as possible and small numbers as
// small as possible.
// so we traverse and take the max bits then square so such that we get max number
// and squaring it maximize the result

// leetcode - 2897
// tc - O(n + k), sc - O(1)
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long result = 0;
        int mod = (int)1e9 + 7;
        int[] bits = new int[32];

        int mask = 1;
        for(int i = 0; i < 32; i++) {
            for(int num : nums) {
                if((num & mask) > 0) bits[i]++;
            }
            mask = mask << 1;
        }

        // System.out.println(Arrays.toString(bits));

        for(int i = 0; i < k; i++) {
            long num = 0;

            for(int j = 0; j < 32; j++) {
                if(bits[j] > 0) {
                    num = num | (1 << j);
                    bits[j]--;
                }
            }
            result = (result + (num * num) % mod) % mod;
        }
        return (int)result;
    }
}

