package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    Boolean[][] dp;

    private boolean checkAllStar(int j, String pat){
        while(j >= 0){
            if(pat.charAt(j) != '*') return false;
            j--;
        }
        return true;
    }

    private boolean match(int i, int j, String txt, String pat){
        if(i < 0) return checkAllStar(j, pat);
        if(j < 0) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(txt.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?'){
            return dp[i][j] = match(i-1, j-1, txt, pat);
        }

        if(pat.charAt(j) == '*'){
            return dp[i][j] = match(i-1, j, txt, pat) || match(i, j-1, txt, pat);
        }
        return dp[i][j] = false;
    }

    public boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        dp = new Boolean[n][m];

        return match(n-1, m-1, txt, pat);
    }
}
