package Leetcode;

// leetcode - 3212
// tc = O(n*m), sc - O(n*m)
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        int[][] freqx = new int[n][m];
        int[][] freqy = new int[n][m];

        int currx = 0;
        int curry = 0;

        for(int i = 0; i < n; i++) {
            currx = 0;
            curry = 0;

            for(int j = 0; j < m; j++) {
                int prevx = i == 0 ? 0 : freqx[i-1][j];
                int prevy = i == 0 ? 0 : freqy[i-1][j];

                currx += prevx;
                curry += prevy;

                freqx[i][j] = prevx;
                freqy[i][j] = prevy;

                char ch = grid[i][j];

                if(ch == 'X') {
                    currx++;
                    freqx[i][j]++;
                }

                else if(ch == 'Y') {
                    curry++;
                    freqy[i][j]++;
                }

                if(currx == curry && currx != 0) result++;
            }
        }
        return result;
    }
}