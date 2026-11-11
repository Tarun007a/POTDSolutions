package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int prevIdx = mp.getOrDefault(arr[i], -1000000);
            if(i - prevIdx <= k) return true;

            mp.put(arr[i], i);
        }
        return false;
    }
}
