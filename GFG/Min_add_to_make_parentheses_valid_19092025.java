package GFG;
class Solution {
    public int minParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') st.push('(');
            else{
                if(st.isEmpty()) count++;
                else st.pop();
            }
        }
        return count + st.size();
    }
}
