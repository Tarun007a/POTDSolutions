package GFG;

class Solution {
    public int[][] getRightLcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] lcs = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            lcs[i][m] = 0;
        }
        for(int j = 0; j <= m; j++) {
            lcs[n][j] = 0;
        }

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) lcs[i][j] = 1 + lcs[i+1][j+1];
                else lcs[i][j] = Math.max(lcs[i+1][j], lcs[i][j+1]);
            }
        }

        return lcs;
    }

    // this return an array whcih is one index ahead so consider it
    public int[][] getLeftLcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] lcs = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            lcs[i][0] = 0;
        }
        for(int j = 0; j <= m; j++) {
            lcs[0][j] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) lcs[i][j] = 1 + lcs[i-1][j-1];
                else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }

        return lcs;
    }

    private int getRightLen(int i, int j, int[][] right) {
        return right[i][j];
    }

    private int getLeftLen(int i, int j, int[][] left) {
        return left[i][j];
    }

    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int result = 0;

        int[][] left = getLeftLcs(s1, s2);
        int[][] right = getRightLcs(s1, s2);

        int required = right[0][0]+1;

        for(int i = 0; i <= n; i++) {
            HashSet<Character> processed = new HashSet<>();
            for(int j = 0; j < m; j++) {
                char ch = s2.charAt(j);

                int curr = 1 + getLeftLen(i, j, left) + getRightLen(i, j+1, right);
                if(curr == required && !processed.contains(ch)) {
                    result++;
                    processed.add(ch);
                }
            }
        }

        return result;
    }
}
