package Leetcode;

//Time - O(n) and O(1) space
public class Solution {
    public static int canBeTypedWords(String text, String brokenLetters) {
        int n = text.length();
        int count = 0;
        boolean flag = true;
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) broken[c - 'a'] = true;

        for (int i = 0; i <= n; i++) {
            if (i < n && text.charAt(i) != ' ') {
                if (broken[text.charAt(i) - 'a']) {
                    flag = false;
                }
            } else {
                if (flag) count++;
                flag = true;
            }
        }
        return count;
    }
}