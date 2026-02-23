package Leetcodecontest.weekly490;

// leetcode - 3850
class Solution {
    int n;

    HashMap<Integer, HashMap<Long, HashMap<Long, Integer>>> dp;

    private int helper(int idx, long multiply, long divide, int[] nums, long k){
        if(idx == n) {
            if(multiply % divide != 0) return 0;
            long val = multiply / divide;
            return val == k ? 1 : 0;
        }

        if(dp.containsKey(idx)){
            HashMap<Long, HashMap<Long, Integer>> num = dp.get(idx);
            if(num.containsKey(multiply)) {
                if(num.get(multiply).containsKey(divide)) return num.get(multiply).get(divide);
            }
            else num.put(multiply, new HashMap<>());
        }
        else{
            dp.put(idx, new HashMap<>());
            dp.get(idx).put(multiply, new HashMap<>());
        }

        int op1 = helper(idx+1, multiply * nums[idx], divide, nums, k);
        int op2 = helper(idx+1, multiply, divide * nums[idx], nums, k);
        int op3 = helper(idx+1, multiply, divide, nums, k);

        dp.get(idx).get(multiply).put(divide, op1 + op2 + op3);

        return op1 + op2 + op3;
    }
    public int countSequences(int[] nums, long k) {
        n = nums.length;
        dp = new HashMap<>();
        int result = helper(0, 1, 1, nums, k);
        return result;
    }
}