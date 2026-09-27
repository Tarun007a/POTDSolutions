package Leetcode;

// leetcode - 1190
// tc & sc - O(n)
class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int i = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                while(st.peek() != '(') q.add(st.pop());
                st.pop();

                if(st.size() == 0) {
                    while(!q.isEmpty()) sb.append(q.remove());
                }
                else {
                    while(!q.isEmpty()) st.push(q.remove());
                }
            }
            else if(ch == '(' || st.size() > 0) st.push(ch);
            else sb.append(ch);
        }
        return sb.toString();
    }
}
