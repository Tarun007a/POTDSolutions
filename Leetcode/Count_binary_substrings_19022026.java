package Leetcode;

// leetcode - 696
// tc - O(n), sc - O(1)

class Solution {
    public int countBinarySubstrings(String s) {
        int st = 0;
        int zero = 0;
        int one = 0;
        int result = 0;
        int n = s.length();

        char prev = s.charAt(0);
        int i = 0;
        while(i < n && s.charAt(i) == prev){
            if(prev == '0') zero++;
            else one++;
            i++;
        }

        for(; i < n; i++){
            char ch = s.charAt(i);
            if(ch != prev){
                if(ch == '1') one++;
                else zero++;
            }
            else{
                result += Math.min(one, zero);
                if(ch == '0'){
                    zero = 1;
                    prev = '1';
                }
                else{
                    one = 1;
                    prev = '0';
                }
            }
        }
        return result + Math.min(zero, one);
    }
}