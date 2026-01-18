package Leetcodecontest.weekly485;

// Q-1
// leetcode - 3813
class Solution {
    public int vowelConsonantScore(String s) {
        int vowel = 0;
        int cons = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowel++;
            else if(ch >= 97 && ch <= 122) cons++;
        }

        if(cons == 0) return 0;
        return vowel/cons;
    }
}