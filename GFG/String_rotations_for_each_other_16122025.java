package GFG;

// tc - O(n), sc - O(n)
class Solution {
    private boolean kmp(String text, String pattern, int[] lps){
        int n = text.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;

        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

            if(j == m) return true;
            else if(i < n && text.charAt(i) != pattern.charAt(j)){
                if(j == 0) i++;
                else j = lps[j-1];
            }
        }
        return false;
    }

    private int[] createLPS(String s){
        int n = s.length();

        int[] lps = new int[n];

        lps[0] = 0;
        int i = 1;
        int len = 0;

        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len == 0){
                    lps[i] = 0;
                    i++;
                }
                else len--;
            }
        }
        return lps;
    }

    public boolean areRotations(String s1, String s2) {
        int[] lps = createLPS(s1);
        return kmp(s2 + s2, s1, lps);
    }
}
