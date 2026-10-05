package Leetcode;

// leetcode - 856
// tc - O(n), sc - O(n)
class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();

        int score = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(score);
                score = 0;
            }
            else {
                if (s.charAt(i - 1) == '(') score = stack.peek() + 1;
                else score = stack.peek() + (2 * score);
                stack.pop();
            }
        }
        return score;
    }
}