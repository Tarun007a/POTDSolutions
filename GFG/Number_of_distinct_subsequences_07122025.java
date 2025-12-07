package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int distinctSubseq(String s) {
        int n = s.length();
        int mod = 1000000007;

        // state for ith  the number of distinct subseq formed till index i+1
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty subsequence

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';

            // double the previous count
            // as let we have "", "a" and b comes then we will have "", "a", "b", "ab"
            // the previous ones and the new char will the previous ones
            dp[i] = (2 * dp[i - 1]) % mod;

            // if character appeared before → subtract duplicates
            // now if the char has already appeared at i then we cannot do as it will
            // repeat, let the previous char came at idx so for all the substrings the
            // char has been appended and leaving it we can append for all so substract
            // dp[last[ch]] to remove the count of those repeated str whcih are alredy done
            // by using idx
            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + mod) % mod;
            }

            // update last occurrence
            last[ch] = i;
        }

        return dp[n];
    }
}
