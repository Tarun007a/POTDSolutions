package GFG;

// tc - O(n), sc - O(k)
class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        int n = arr.length;
        int result = 0;
        long sum = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            int mod = (int)((sum % k) + k) % k;

            // System.out.println(sum + " " + mod);

            if(mp.containsKey(mod)) {
                result = Math.max(result, i - mp.get(mod));
            }
            else {
                mp.put(mod, i);
            }
        }

        return result;
    }
}

