package Leetcode;

// leetcode - 3886
// tc - O(nlogn + sqrt(n) * n), sc - O(n)
class Solution {
    private boolean isSortable(int[] nums, int[] sortedNums, int k) {
        int n = nums.length;

        for(int i = 0; i < n; i += k) {
            int idx = -1;

            if(nums[i+k-1] == sortedNums[i]) {
                idx = i+k-1;
                while(idx >= i && nums[idx] == sortedNums[i]) idx--;
                idx++;
            }

            if(idx == -1) {
                for(int j = i; j < i+k; j++) {
                    if(nums[j] == sortedNums[i]) {
                        idx = j;
                        break;
                    }
                }
            }

            if(idx == -1) return false;

            for(int j = i; j < i+k; j++) {
                if(nums[idx] != sortedNums[j]) return false;
                idx++;

                if(idx == i+k) idx = i;
            }
        }
        return true;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sqrt = (int)Math.sqrt(n);
        int result = 0;
        int[] sortedNums = new int[n];

        for(int i = 0; i < n; i++) sortedNums[i] = nums[i];
        Arrays.sort(sortedNums);

        for(int i = 1; i <= sqrt; i++) {
            if(n % i == 0) {
                int val1 = i;
                int val2 = n / i;

                if(isSortable(nums, sortedNums, val1)) result += val1;
                if(val1 != val2 && isSortable(nums, sortedNums, val2)) result += val2;
            }
        }
        return result;
    }
}