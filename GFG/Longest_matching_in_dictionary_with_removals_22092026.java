package GFG;

// tc - O(n), sc - O(n)
class Solution {
    private boolean isPossible(String s, int[][] next) {
        int idx = 0;
        for(char ch : s.toCharArray()) {
            idx = next[idx][ch-'a'];
            if(idx == -1) return false;

        }
        return true;
    }

    public String findLongestWord(String s, List<String> d) {
        int n = s.length();
        String result = "";

        int[][] next = new int[n+1][26];
        int[] curr = new int[26];

        Arrays.fill(curr, -1);

        for(int i = n-1; i >= 0; i--) {
            for(int idx = 0; idx < 26; idx++) next[i+1][idx] = curr[idx];
            curr[s.charAt(i)-'a'] = i+1;
        }

        for(int idx = 0; idx < 26; idx++) next[0][idx] = curr[idx];

        for(String str : d) {
            if(isPossible(str, next)) {
                if(result.length() < str.length()) {
                    result = str;
                }
                else if(result.length() == str.length()) {
                    if(str.compareTo(result) < 0) result = str;
                }
            }
        }
        return result;
    }
}