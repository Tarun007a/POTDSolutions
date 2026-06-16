package Leetcode;

// leetcode - 3612
// tc - O(n^2), sc - O(n)
class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(sb.length() == 0)continue;
                sb.deleteCharAt(sb.length()-1);
            }
            else if(ch == '%') sb.reverse();
            else if(ch == '#') sb.append(sb);
            else sb.append(ch);
        }
        return sb.toString();
    }
}