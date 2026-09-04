package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int max = 0;
        int curr = 0;

        for(int i = 0; i < m; i++) curr += arr.get(i);

        max = curr;

        for(int i = 0; i < n; i++) {
            curr -= arr.get(i);
            curr += arr.get((i + m) % n);

            max = Math.max(max, curr);
        }
        return max;
    }
}