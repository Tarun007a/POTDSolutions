package Leetcode;

// leetcode - 3499
// tc - O(n), sc - O(n)
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int m = t.length();

        int[] prefixZeros = new int[m];
        int[] suffixZeros = new int[m];
        int[] prefixOnes = new int[m];
        int[] suffixOnes = new int[m];

        for (int i = 0; i < m; i++) {
            if (t.charAt(i) == '0') {
                prefixZeros[i] = (i > 0 ? prefixZeros[i - 1] : 0) + 1;
            }
            else {
                prefixOnes[i] = (i > 0 ? prefixOnes[i - 1] : 0) + 1;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            if (t.charAt(i) == '0') {
                suffixZeros[i] = (i + 1 < m ? suffixZeros[i + 1] : 0) + 1;
            }
            else {
                suffixOnes[i] = (i + 1 < m ? suffixOnes[i + 1] : 0) + 1;
            }
        }

        int active = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') active++;
        }

        int ans = active;

        int i = 0;
        while (i < m) {
            if (t.charAt(i) == '1') {

                int j = i;
                while (j + 1 < m && t.charAt(j + 1) == '1') {
                    j++;
                }

                if (i > 0 && j < m - 1 &&
                        t.charAt(i - 1) == '0' &&
                        t.charAt(j + 1) == '0') {

                    int leftZeros = prefixZeros[i - 1];
                    int rightZeros = suffixZeros[j + 1];

                    ans = Math.max(ans, active + leftZeros + rightZeros);
                }
                i = j + 1;
            }
            else i++;
        }

        return ans;
    }
}
