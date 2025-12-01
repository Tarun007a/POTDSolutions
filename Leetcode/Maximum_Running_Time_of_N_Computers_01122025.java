package Leetcode;

// tc - O(nlog(n)), sc - O(1)
// leetcode - 2141
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;

        for (int power : batteries) sum += power;

        long left = 1;
        long right = sum / n;

        while (left < right){
            long target = right - (right - left) / 2;
            long extra = 0;

            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (long)(n * target)) left = target;
            else right = target - 1;
        }
        return left;
    }
}