package Leetcode;

// leetcode - 1590
// tc - O(n), sc O(n)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = -1;

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            sum = sum % p;
            nums[i] = nums[i]%p;
        }

        if(sum == 0)return 0;

        int mod = sum;
        int currSum = 0;
        mp.put(0, -1);

        for(int i = 0; i < n; i++){
            if(nums[i] == mod)return 1;

            currSum += nums[i];
            currSum = currSum % p;
            int l = (currSum-mod+p)%p; //as currSum-mod may get -ve values so add extra p
            if(mp.containsKey(l)){
                if(ans == -1)ans = i-mp.get(l);
                else ans = Math.min(ans, i-mp.get(l));
            }
            mp.put(currSum, i);
        }
        if(ans == n)return -1;      //you cannot take full array
        return ans;
    }
}