package Leetcode;

// leetcode - 3471
// tc - O(n*k), sc - O(n)
class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int n = nums.length;

        for(int i = 0; i < n-k+1; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < i+k; j++){
                set.add(nums[j]);
            }
            for(int l : set)freq[l]++;
        }

        int max = -1;
        for(int i = 0; i < 51; i++){
            if(freq[i] == 1)max = i;
        }
        return max;
    }
}
