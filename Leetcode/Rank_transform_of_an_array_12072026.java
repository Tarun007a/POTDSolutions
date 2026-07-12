package Leetcode;

// leetcode - 1331
// tc - O(nlogn), sc - O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int rank = 1;
        int[] nums = new int[n];
        int[] result = new int[n];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++) nums[i] = arr[i];

        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(!mp.containsKey(nums[i])) {
                mp.put(nums[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < n; i++) {
            result[i] = mp.get(arr[i]);
        }
        return result;
    }
}

