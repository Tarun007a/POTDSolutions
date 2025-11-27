package GFG;

// tc - O(n), sc - O(1)
//Let the number of elements with bit=1 be m.
// Number of total subsets = 2^m.
// How many of these subsets have odd number of elements selected?
// Exactly half → 2^(m-1).
class Solution {
    public int subsetXORSum(int[] arr) {
        int n = arr.length;
        int ans = 0;

        int pow = 1 << (n - 1);         // Precompute half for multiplication

        for (int b = 0; b < 32; b++) {
            int mask = 1 << b;

            int count = 0;
            for (int x : arr) {
                if ((x & mask) != 0) count++;
            }

            if (count == 0) continue;

            ans += mask * pow;
        }

        return ans;
    }
}
