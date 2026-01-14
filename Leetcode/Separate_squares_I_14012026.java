package Leetcode;

// leetcode - 3453
// tc - O(nlog(max)), sc - O(1)
class Solution {
    private boolean check(double Y, int[][] squares) {
        double below = 0.0;
        double above = 0.0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            double top = y + l;

            if (top <= Y) below += l * l;
            else if (y >= Y) above += l * l;
            else {
                double belowHeight = Y - y;
                double aboveHeight = top - Y;

                below += belowHeight * l;
                above += aboveHeight * l;
            }
        }

        return below >= above;
    }
    public double separateSquares(int[][] squares) {
        double lo = Double.MAX_VALUE;
        double hi = Double.MIN_VALUE;

        for (int[] s : squares) {
            lo = Math.min(lo, s[1]);
            hi = Math.max(hi, s[1] + s[2]);
        }
        double ans = hi;

        // binary search on real numbers
        while (lo <= hi) {
            double mid = (lo + hi) / 2.0;
            if(mid == lo || mid == hi) return mid;
            if (check(mid, squares)) {
                ans = mid;
                hi = mid;
            }
            else lo = mid;
        }

        return ans;
    }
}
