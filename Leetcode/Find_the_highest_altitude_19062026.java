// leetcode - 1732
// tc - O(n), sc - O(1)
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;

        for(int i : gain) {
            curr += i;
            max = Math.max(max, curr);
        }
        return max;
    }
}