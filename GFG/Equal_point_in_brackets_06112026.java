package GFG;

class Solution {
    public int findIndex(String s) {
        int n = s.length();

        int opening = 0;
        int closing = 0;

        for(char ch : s.toCharArray()) {
            if(ch == ')') closing++;
        }

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') opening++;
            else closing--;

            if(opening == closing) return i+1;
        }

        return 0;
    }
}