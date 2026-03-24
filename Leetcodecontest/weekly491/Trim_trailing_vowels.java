package Leetcodecontest.weekly491;

// leetcode - 3856
class Solution {
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int i = n-1;

        while(i >= 0){
            char ch = s.charAt(i);
            if(!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) break;
            i--;
        }
        return s.substring(0, i+1);
    }
}
