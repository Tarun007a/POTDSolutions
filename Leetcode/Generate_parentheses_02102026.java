package Leetcode;

// leetcode - 22
// tc - O(2^n), sc - O(n)
class Solution {
    List<String> result;
    private void helper(int open, int close, StringBuilder sb) {
        if(open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        if(open > 0) {
            sb.append("(");
            helper(open-1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open < close) {
            sb.append(")");
            helper(open, close-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(n, n, new StringBuilder());
        return result;
    }
}