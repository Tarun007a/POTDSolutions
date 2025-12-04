package Leetcode;

// leetcode - 2211
// tc - O(n), sc - O(1)
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0;
        int r = n - 1;
        int result = 0;

        while (l < n && directions.charAt(l) == 'L') l++;

        while (r >= l && directions.charAt(r) == 'R') r--;

        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') result++;
        }
        return result;
    }
}
