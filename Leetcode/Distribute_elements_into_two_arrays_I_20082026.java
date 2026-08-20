package Leetcode;

// leetcode - 3069
// tc - O(n), sc - O(n)
class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        int[] result = new int[n];

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < n; i++) {
            if(arr1.get(idx1) > arr2.get(idx2)) {
                idx1++;
                arr1.add(nums[i]);
            }
            else {
                arr2.add(nums[i]);
                idx2++;
            }
        }

        for(int num : arr1) result[idx++] = num;
        for(int num : arr2) result[idx++] = num;

        return result;
    }
}