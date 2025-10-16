package Leetcode;

// leetcode - 2598
// tc - O(n) sc - O(n)
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i : nums){
            int rem = i%value;
            if(rem < 0) rem += value;
            mp.put(rem, mp.getOrDefault(rem, 0)+1);
        }

        int min = 0;
        int cnt = mp.getOrDefault(0, 0);
        for(int i = 1; i < value; i++){
            int curr = mp.getOrDefault(i, 0);
            if(curr < cnt){
                cnt = curr;
                min = i;
            }
        }
        return value*cnt+min;
    }
}