package Leetcode;

// leetcode - 32
// tc - O(n), sc - O(1)

// left to right while checking that nothing goes invalid if it goes then move
// right to left same
// if val gets -ve in left to right means there is an extra ) and non one can
// balance it now and same for the righ to left pass
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int idx = 0;
        int val = 0;
        int result = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') val++;
            else val--;

            if(val < 0) {
                val = 0;
                idx = i+1;
            }

            // System.out.println(i + " " + idx + " " + val);
            if(val == 0) result = Math.max(result, i - idx + 1);
        }

        idx = n-1;
        val = 0;
        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == '(') val--;
            else val++;

            if(val < 0) {
                val = 0;
                idx = i-1;
            }
            if(val == 0) result = Math.max(result, idx - i + 1);
        }

        return result;
    }
}