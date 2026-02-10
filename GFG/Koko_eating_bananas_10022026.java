package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    public int kokoEat(int[] piles, int k) {
        int left = 1;
        int right = (int)1e9;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int curr = 0;
            for (int x : piles) {
                curr += (x + mid - 1) / mid;
            }
            if (curr <= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}