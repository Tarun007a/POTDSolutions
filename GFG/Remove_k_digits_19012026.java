package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public String removeKdig(String s, int k) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                k--;
                st.pop();
            }
            st.push(ch);
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()) result.append(st.pop());
        result.reverse();

        int i = 0;
        int n = result.length();

        while(i < n && result.charAt(i) == '0') i++;

        if(i >= n - k) return "0";
        return result.substring(i, n - k);
    }
}
