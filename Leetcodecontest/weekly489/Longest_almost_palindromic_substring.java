package Leetcodecontest.weekly489;

// leetcode - 3844
class Solution {
    int n;
    private int findPalindromic(int i, int j, boolean canRemove, String s){
        if(i < 0 || j >= n){
            if(i < 0 && j >= n) return 0;
            if(canRemove) return 1;
            return 0;
        }

        int idx = canRemove ? 1 : 0;

        if(s.charAt(i) == s.charAt(j)) return  2 + findPalindromic(i-1, j+1, canRemove, s);
        else if(!canRemove) return  0;
        return 1 + Math.max(findPalindromic(i-1, j, false, s), findPalindromic(i, j+1, false, s));
    }

    public int almostPalindromic(String s) {
        n = s.length();
        int result = 0;

        for(int i = 0; i < n; i++){
            result = Math.max(result, 1 + findPalindromic(i-1, i+1, true, s));
            result = Math.max(result, findPalindromic(i, i+1, true, s));
        }
        return result;
    }
}