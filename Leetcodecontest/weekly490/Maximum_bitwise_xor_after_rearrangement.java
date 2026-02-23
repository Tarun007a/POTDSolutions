package Leetcodecontest.weekly490;

// leetcode - 3849
class Solution {
    public String maximumXor(String s, String t) {
        int zeros = 0;
        int ones = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : t.toCharArray()) {
            if(ch == '0') zeros++;
            else ones++;
        }

        for(char ch : s.toCharArray()) {
            if(ch == '0'){
                if(ones > 0){
                    ones--;
                    sb.append('1');
                }
                else{
                    zeros--;
                    sb.append('0');
                }
            }
            else {
                if(zeros > 0){
                    zeros--;
                    sb.append('1');
                }
                else{
                    ones--;
                    sb.append('0');
                }
            }
        }
        return sb.toString();
    }
}

