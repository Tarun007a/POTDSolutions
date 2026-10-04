package Leetcodecontest.weekly522;

package Leetcode;

class Solution {
    public int minRotations(String s) {
        int prev = 0;
        int result = 0;

        for(char ch : s.toCharArray()) {
            int num = ch - '0';

            int count = Math.max(num, prev) - Math.min(num, prev);
            result += Math.min(count, 10 - count);
            prev = num;
        }
        return result;
    }
}