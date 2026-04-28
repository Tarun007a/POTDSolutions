package GFG;

// tc - O(26 * n), sc - O(1)
class Solution {
    private int maxPossible(String s, int k, char ch) {
        int n = s.length();
        int i = 0;
        int diff = 0;
        int max = 0;

        for(int j = 0; j < n; j++) {
            char curr = s.charAt(j);

            if(curr != ch) diff++;

            while(diff > k) {
                char toRemove = s.charAt(i);
                if(toRemove != ch) diff--;
                i++;
            }
            max = Math.max(max, j-i+1);
        }
        return max;
    }

    public int longestSubstr(String s, int k) {
        int result = 0;

        for(char ch = 'A'; ch <= 'Z'; ch = (char)(ch+1)) {
            result = Math.max(result, maxPossible(s, k, ch));
        }
        return result;
    }
}
