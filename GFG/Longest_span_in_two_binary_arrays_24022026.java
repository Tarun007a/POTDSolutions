package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        int sum1 = 0;
        int sum2 = 0;
        int result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        for(int i = 0; i < n; i++){
            sum1 += a1[i];
            sum2 += a2[i];

            int diff = sum1 - sum2;
            if(mp.containsKey(diff)) result = Math.max(result, i - mp.get(diff));
            else mp.put(diff, i);
        }
        return result;
    }
}