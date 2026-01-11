package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    int n;
    int m;
    Pair[][][] dp;

    static class Pair{
        int st;
        int len;
        public Pair(int st, int len){
            this.st = st;
            this.len = len;
        }
    }

    private Pair helper(int i, int j, int isTook, String s1, String s2){
        if(j == m) return new Pair(i, 0);
        if(i == n) return new Pair(-1, -1);

        if(dp[i][j][isTook] != null) return dp[i][j][isTook];

        Pair result = helper(i+1, j, isTook, s1, s2);
        if(result.st != -1 && isTook == 1) result = new Pair(i, result.len+1);

        if(s1.charAt(i) == s2.charAt(j)){
            Pair curr = helper(i+1, j+1, 1, s1, s2);

            if(curr.st != -1){
                if(result.st == -1 || curr.len+1 <= result.len) result = new Pair(i, curr.len+1);
            }
        }

        return dp[i][j][isTook] = result;
    }

    public String minWindow(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        dp = new Pair[n][m][2];

        Pair result = helper(0, 0, 0, s1, s2);

        if(result.st == -1) return "";
        return s1.substring(result.st, result.st+result.len);
    }
}

