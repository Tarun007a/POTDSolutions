package Leetcode;

// leetcode - 3234
// tc - O(n*sqrt(n)), sc - O(n)
class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                prefix[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0;

            for (int j = i; j < n; j++) {

                ones = prefix[j];
                if (i != 0) ones -= prefix[i - 1];

                zeros = (j - i + 1) - ones;

                if (zeros * zeros > ones) {
                    j += (zeros * zeros - ones - 1);
                    continue;
                }

                if (zeros * zeros <= ones) {
                    ans++;

                    if (zeros * zeros < ones) {
                        int diff = (int) Math.sqrt(ones) - zeros;
                        int nextj = j + diff;

                        if (nextj >= n) ans += (n - j - 1);
                        else ans += diff;

                        j = nextj;
                    }
                }
            }
        }
        return ans;
    }
}