package Leetcode;

// leetcode - 1021
// tc - O(n), sc - O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        int val = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                val++;
                if(val == 1) continue;
                else sb.append(ch);
            }
            else {
                val--;
                if(val == 0) continue;
                else sb.append(ch);
            }
        }
        return sb.toString();
    }
}