package Leetcode;

// leetcode - 1758
// tc - O(n), sc - O(1)
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean flag = true;
        int op1 = 0;    // start with 0
        int op2 = 0;    // start with 1

        for(char ch : s.toCharArray()) {
            if(flag) {
                if(ch == '0') op2++;
                else op1++;
            }
            else {
                if(ch == '0') op1++;
                else op2++;
            }
            flag = !flag;
        }
        return Math.min(op1, op2);
    }
}