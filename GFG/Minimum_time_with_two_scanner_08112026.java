package GFG;

// tc - O(log(s1*n)), sc - O(1)
class Solution {
    public int minTime(int n, int s1, int s2) {
        int lo = 1;
        int hi = s1 * n;
        int result = 0;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;

            if((mid / s1 + mid / s2) >= n) {
                result = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return result;
    }
}