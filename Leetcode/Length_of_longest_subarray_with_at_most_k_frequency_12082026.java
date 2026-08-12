package Leetcode;

// leetcode - 2958
// tc - O(n), sc - O(1)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < n){
            int num = nums[j];
            if(mp.containsKey(num)){
                mp.put(num,mp.get(num)+1);
                while(mp.get(num) > k){
                    mp.put(nums[i],mp.get(nums[i++])-1);
                }
            }
            else{
                mp.put(num,1);
            }
            j++;
            ans = Math.max(ans,j-i);
        }
        return ans;
    }
}