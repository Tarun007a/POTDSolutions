package Leetcode;

// Leetcode - 1404
// tc - O(n), sc - O(1)
class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int ans = 0;

        for(int i = n-1; i > 0; i--){
            int digit = Character.getNumericValue(s.charAt(i))+carry;

            if(digit%2 == 1){
                carry = 1;
                ans += 2;
            }
            else ans++;
        }
        return ans+carry;
    }
}