package Leetcode;

// The key idea is to take k-1 minimum elements from the subarray of size dist+1 after fixing the 2nd
// subarray start as when you fix it you have to take k-1 minimum for the window size size of dist+1
// so we will try each window excluding 1, Iterate form i = 1 to the point where we can take atleast
// k diffrent subarrays

// leetcode - 3013
// tc - O(nlogk), sc - O(n)
class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeSet<int[]> kMinimum = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        TreeSet<int[]> remaining = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        long sum = 0;

        int i = 1;

        while (i - dist <= 0) {
            int[] cur = new int[]{nums[i], i};
            kMinimum.add(cur);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                int[] largest = kMinimum.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }
            i++;
        }

        long result = Long.MAX_VALUE;

        while (i < n) {
            int[] cur = new int[]{nums[i], i};
            kMinimum.add(cur);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                int[] largest = kMinimum.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }

            result = Math.min(result, sum);

            int remIdx = i - dist;
            int[] toRemove = new int[]{nums[remIdx], remIdx};

            if (kMinimum.remove(toRemove)) {
                sum -= nums[remIdx];

                if (!remaining.isEmpty()) {
                    int[] promote = remaining.pollFirst();
                    kMinimum.add(promote);
                    sum += promote[0];
                }
            }
            else remaining.remove(toRemove);
            i++;
        }
        return nums[0] + result;
    }
}