package Leetcodecontest.weekly518;

class Solution {
    private int getScore(String s) {
        int n = s.length();
        int score = 0;

        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == s.charAt(i-1)) score++;
        }
        return score;
    }

    public int countRotations(String s, int k) {
        int n = s.length();
        int result = 0;

        for(int i = 0; i < n; i++) {
            String str = s.substring(i+1) + s.substring(0, i+1);
            int score = getScore(str);

            if(score == k) result++;
        }
        return result;
    }
}