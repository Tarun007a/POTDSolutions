package GFG;

// tc & sc - O(n)
class Solution {
    private int[][] dp;

    public int countWays(int n, int k) {
        if (n == 1) return k;

        int same = k;              // for n = 2
        int diff = k * (k - 1);    // for n = 2

        for (int i = 3; i <= n; i++) {
            int newSame = diff;
            int newDiff = (same + diff) * (k - 1);

            same = newSame;
            diff = newDiff;
        }

        return same + diff;
    }
}