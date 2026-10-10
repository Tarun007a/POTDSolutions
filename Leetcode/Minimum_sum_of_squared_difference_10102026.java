package Leetcode;

// leetcode - 2333
// tc - O(n + max), sc - O(max)
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;
        long k = k1 + k2;
        long result = 0;

        for(int num : nums1) max = Math.max(max, num);
        for(int num : nums2) max = Math.max(max, num);

        int[] freq = new int[max+1];

        for(int i = 0; i < n; i++) {
            freq[Math.abs(nums1[i] - nums2[i])]++;
        }

        int idx = max;
        while(k > 0 && idx > 0) {
            if(freq[idx] <= k) {
                k -= freq[idx];
                freq[idx-1] += freq[idx];
                freq[idx] = 0;
                idx--;
            }
            else {
                freq[idx] -= k;
                freq[idx-1] += k;
                k = 0;
                idx--;
            }
        }

        for(int i = 1; i < max+1; i++) {
            result += ((long)i * i) * (long)freq[i];
        }
        return result;
    }
}