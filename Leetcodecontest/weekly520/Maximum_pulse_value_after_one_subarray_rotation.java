package Leetcodecontest.weekly520;

class Solution {
    private long getMax(long[] nums) {
        long max = 0;
        long curr = 0;

        for(long num : nums) {
            curr += num;
            if(curr < 0) curr = 0;

            if(max < curr) max = curr;
        }
        return max;
    }

    public long maxValue(int[] nums) {
        int n = nums.length;
        long result = 0;
        long curr = 0;

        long[] change = new long[n];

        for(int i = 0; i < n; i++) {
            if(i%2 == 0) curr += (long)nums[i];
            else curr -= (long)nums[i];
        }

        for(int i = 0; i < n; i++) {
            if(i%2 == 0) {
                change[i] = -2l * (long)nums[i];
            }
            else {
                change[i] = 2l * (long)nums[i];
            }
        }

        long[] adv1 = new long[n];
        long[] adv2 = new long[n];

        for(int i = 0; i < n-1; i++) {
            if(i % 2 == 0) adv1[i] = change[i] + change[i+1];
            else adv2[i] = change[i] + change[i+1];
        }

        // System.out.println(Arrays.toString(adv1));
        // System.out.println(Arrays.toString(adv2));

        long max1 = getMax(adv1);
        long max2 = getMax(adv2);

        return curr + Math.max(max1, max2);
    }
}
