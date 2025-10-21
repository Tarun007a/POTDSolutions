package Leetcode;

// consider the constraint k. It is easy to see that only numbers within the range [m-k,m+k] can be transformed into m
// . If we sort nums, we can use binary search to find, lower bound and upper bound.
// If the enumerated m already exist in nums, we should not waste operations on those
// occurrences. Therefore, we preprocess the occurrence count of each number in nums and
// include it in the final calculation of f i.

class Solution {
    private int leftBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] < value)  left = mid + 1;
            else  right = mid;
        }
        return left;
    }

    private int rightBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left + right + 1) / 2;
            if (nums[mid] > value) right = mid - 1;
            else left = mid;
        }
        return left;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n =  nums.length;
        int ans = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            int l = leftBound(nums, i - k);
            int r = rightBound(nums, i + k);
            int curr = 0;
            if (mp.containsKey(i)) curr = Math.min(r - l + 1, mp.get(i) + numOperations);
            else curr = Math.min(r - l + 1, numOperations);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}