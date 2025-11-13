package Leetcode;

// leetcode - 3228
// tc - O(n), sc - O(n)
public class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int result = 0;
        int count = 0;
        int i = 0;
        while (i < n) {
            if(s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                result += count;
            }
            else count++;
            i++;
        }
        return result;
    }
}
