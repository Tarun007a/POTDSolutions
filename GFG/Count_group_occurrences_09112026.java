package GFG;

// tc - O(n), sc - O(1)
class Solution {
    int getCount(String s, int k) {
        int n = s.length();
        char prev = 'A';
        int result = 0;
        int[] count = new int[26];

        for(char ch : s.toCharArray()) {
            if(ch != prev) {
                count[ch - 'a']++;
                prev = ch;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] == k) result++;
        }
        return result;
    }
}