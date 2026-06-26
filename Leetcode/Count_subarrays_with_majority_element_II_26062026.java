package Leetcode;

// tc - O(n), sc - O(n)
// Key idea is if nums[i] == target then do +1 else -1 and build a prefix sum
// at first insert (0, 1) means 0 appears 1 and then we just iterate in prefix sum
// and count (i, j) where prefixSum[i] < prefixSum[j]. So now we simply need count
// of smaller element previously in prefixSum array,
// Here the fact is that prefixSum always changes by 1 so if prefixSum,
//   -> increases by 1 means the let the prev value be x so the smaller count will
//      increase by freq of x
//   -> decreases by 1 means let the prev value be x so the smaller count will
//      decrease by freq of x
// so we simply store the running freq of prefixSum visited in a map.
 class Solution {
     public long countMajoritySubarrays(int[] nums, int target) {
         int n = nums.length;
         long result = 0;
         int[] prefixSum = new int[n];
         HashMap<Integer, Integer> mp = new HashMap<>();

         int count = 0;
         for(int i = 0; i < n; i++) {
             if(nums[i] == target) count++;
             else count--;

             prefixSum[i] = count;
         }

         int smaller = 0;
         mp.put(0, 1);
         int prev = 0;

         for(int i = 0; i < n; i++) {
             int curr = prefixSum[i];

             if(curr > prev) {
                 smaller += mp.get(prev);
                 result += smaller;
             }
             else {
                 if(!mp.containsKey(curr)) mp.put(curr, 0);
                 smaller -= mp.get(curr);
                 result += smaller;
             }
             prev = curr;
             mp.put(curr, mp.getOrDefault(curr, 0) + 1);
         }
         return result;
     }
 }


// Just reduced the two loops in one
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long result = 0;
        int[] prefixSum = new int[n];
        HashMap<Integer, Integer> mp = new HashMap<>();

        int curr = 0;

        int smaller = 0;
        mp.put(0, 1);
        int prev = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == target) curr++;
            else curr--;

            if(curr > prev) {
                smaller += mp.get(prev);
                result += smaller;
            }
            else {
                if(!mp.containsKey(curr)) mp.put(curr, 0);
                smaller -= mp.get(curr);
                result += smaller;
            }
            prev = curr;
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        }
        return result;
    }
}