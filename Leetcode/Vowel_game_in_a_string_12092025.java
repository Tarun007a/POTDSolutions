package Leetcode;

// leetcde 3227
// Time complexity - O(n) and space complexity - O(1)
public class Vowel_game_in_a_string_12092025 {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        boolean isVowel = false;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        }
        return false;
    }
}