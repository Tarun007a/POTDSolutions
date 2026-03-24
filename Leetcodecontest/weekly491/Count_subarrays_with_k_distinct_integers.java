package Leetcodecontest.weekly491;

// leetcode - 3859
class Solution {
    private int getNewNumIdx(HashMap<Integer, Integer> mp, int i, int[] nums){
        int n = nums.length;

        while(i < n){
            int curr = nums[i];
            if(!mp.containsKey(curr)) return i;
            i++;
        }
        return n;
    }
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int eligibal = 0;
        int st = 0;
        int newNumIdx = -1;

        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int prev = mp.getOrDefault(num, 0);
            mp.put(num, prev+1);

            if(prev < m && prev+1 == m) eligibal++;

            while(mp.size() > k) {
                int toRemove = nums[st++];
                if(mp.get(toRemove) == m) eligibal--;

                if(mp.get(toRemove) == 1) mp.remove(toRemove);
                else mp.put(toRemove, mp.get(toRemove)-1);
            }

            while(mp.size() == k && eligibal == k) {
                if(newNumIdx <= i) newNumIdx = getNewNumIdx(mp, i+1, nums);;
                result += (long) newNumIdx - i;

                int toRemove = nums[st++];
                if(mp.get(toRemove) == m) eligibal--;

                if(mp.get(toRemove) == 1) mp.remove(toRemove);
                else mp.put(toRemove, mp.get(toRemove)-1);
            }
        }
        return result;
    }
}