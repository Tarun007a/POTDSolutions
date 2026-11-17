package Leetcode;

// leetcode - 2911
// tc - O(n^3logn), sc - O(n^2)
class Solution {
    int[][] changes;
    int n;
    int[][] dp;

    private int getCount(int i, int j, int div, String s) {
        // System.out.println(i + " " + j + " ->");
        int n = j - i + 1;
        int len = n / div;
        int count = 0;

        for(int a = 0; a < div; a++) {
            int lo = i + a;
            int hi = i + a + (len-1) * div;

            // System.out.println(lo + " " + hi);

            for(int k = 0; k < len/2; k++) {
                if(s.charAt(lo) != s.charAt(hi)) count++;
                lo += div;
                hi -= div;
            }
        }
        // System.out.println(count);
        return count;
    }

    private int getMinCount(int i, int j, String s) {
        int n = j - i + 1;
        int result = n;

        for(int div = 1; div <= n/2; div++) {
            if(n % div == 0) result = Math.min(result, getCount(i, j, div, s));
        }

        return result;
    }

    private void fillChangeCount(String s) {
        int n = s.length();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                changes[i][j] = getMinCount(i, j, s);
            }
        }
    }

    private int helper(int i, int k, String s) {
        if(i >= n) return 1000000;
        if(k == 1 && i < n-1) return changes[i][s.length()-1];

        if(dp[i][k] != -1) return dp[i][k];

        int result = 1000000;

        for(int j = i+1; j < s.length(); j++) {
            result = Math.min(result, changes[i][j] + helper(j+1, k-1, s));
        }

        return dp[i][k] = result;
    }

    public int minimumChanges(String s, int k) {
        this.n = s.length();
        dp = new int[n][k+1];

        changes = new int[n][n];

        fillChangeCount(s);

        // for(int[] arr : changes) System.out.println(Arrays.toString(arr));

        for(int[] arr : dp) Arrays.fill(arr, -1);

        return helper(0, k, s);
    }
}
