package GFG;
// O(n) time and space
class Solution {
    private static String helper(String s){
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']')st.push(s.charAt(i));

            else {
                StringBuilder sb = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '[')sb.append(st.pop());
                sb.reverse();
                st.pop();

                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) num.insert(0, st.pop());

                int number = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();

                for(int j = 0; j < number; j++)repeat.append(sb);

                for(char c : repeat.toString().toCharArray())st.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty())res.append(st.pop());

        res.reverse();
        return res.toString();
    }
    static String decodeString(String s) {
        return helper(s);
    }
}
