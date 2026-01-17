package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == ')'){
                int cnt = 0;
                while(st.peek() != '('){
                    st.pop();
                    cnt++;
                }
                if(cnt == 0 || cnt == 1) return true;
                st.pop();
            }
            else st.push(ch);
        }
        return false;
    }
}
