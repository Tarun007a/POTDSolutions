package Leetcode;

// tc - n(logn)
// using accumulated sum + sorting + binary search
class Solution {
    private int getNextIdx(int i, List<Integer> vals){
        int curr = vals.get(i);
        for(int j = i+1; j < vals.size(); j++){
            if(vals.get(j) > curr+2) return j;
        }
        return -1;
    }
    public long maximumTotalDamage(int[] power) {
        if (power.length == 0) return 0;

        Arrays.sort(power);
        List<Integer> vals = new ArrayList<>();
        List<Long> earn = new ArrayList<>();

        for (int i = 0; i < power.length; ) {
            int v = power[i];
            long sum = 0;
            while (i < power.length && power[i] == v) {
                sum += v;
                i++;
            }
            vals.add(v);
            earn.add(sum);
        }

        int n = vals.size();
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = getNextIdx(i, vals);
            long take = earn.get(i);
            if(nextIdx >= 0) take += dp[nextIdx];
            long skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}

// Optimised approach but leads to TLE
// class Solution {
//     HashMap<Integer, HashMap<Integer, Long>> dp;

//     private long helper(int i, int prev, int[] power){
//         if(i == power.length) return 0L;

//         if(dp.containsKey(i) && dp.get(i).containsKey(prev)) return dp.get(i).get(prev);

//         int curr = power[i];
//         if(curr == prev){
//             long result = helper(i+1, prev, power) + (long)(curr);
//             if(!dp.containsKey(i)) dp.put(i, new HashMap<>());
//             dp.get(i).put(prev, result);
//             return result;
//         }

//         long max = helper(i+1, prev, power);      // not take
//         if(curr > prev+2){
//             max = Math.max(max, helper(i+1, curr, power) + (long)curr);
//         }

//         if(!dp.containsKey(i)) dp.put(i, new HashMap<>());
//         dp.get(i).put(prev, max);
//         return max;
//     }
//     public long maximumTotalDamage(int[] power) {
//         int n = power.length;
//         Arrays.sort(power);
//         dp = new HashMap<>();
//         return helper(0, -10, power);
//     }
// }


// Brute force here we cannot memorize as it also include backtracking
// class Solution {
//     private void addToMap(int curr, HashMap<Integer, Integer> mp){
//         mp.put(curr-1, mp.getOrDefault(curr-1, 0)+1);
//         mp.put(curr-2, mp.getOrDefault(curr-2, 0)+1);
//         mp.put(curr+1, mp.getOrDefault(curr+1, 0)+1);
//         mp.put(curr+2, mp.getOrDefault(curr+2, 0)+1);
//     }
//     private void removeFromMap(int curr, HashMap<Integer, Integer> mp){
//         mp.put(curr-1, mp.get(curr-1)-1);
//         mp.put(curr-2, mp.get(curr-2)-1);
//         mp.put(curr+1, mp.get(curr+1)-1);
//         mp.put(curr+2, mp.get(curr+2)-1);
//     }

//     private long helper(int i, HashMap<Integer, Integer> visited, int[] power){
//         if(i == power.length) return 0L;

//         int curr = power[i];
//         long max = helper(i+1, visited, power);
//         if(!visited.containsKey(curr) || visited.get(curr) == 0){
//             addToMap(curr, visited);
//             max = Math.max(helper(i+1, visited, power) + (long)curr, max);
//             removeFromMap(curr, visited);
//         }
//         return max;
//     }
//     public long maximumTotalDamage(int[] power) {
//         int n = power.length;
//         HashMap<Integer, Integer> visited = new HashMap<>();

//         return helper(0, visited, power);
//     }
// }