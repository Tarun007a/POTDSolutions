package GFG;

// tc - O(n*n), sc - O(1)
class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] curr = new int[n];
        int[] prev = new int[n];
        int max = mat[0][0];

        for(int j = 0; j < n; j++) prev[j] = mat[n-1][j];

        for(int i = n-2; i >= 0; i--) {
            int firstMax = 0;
            int secondMax = -1;

            for(int j = 1; j < n; j++) {
                if(prev[j] > prev[firstMax]) {
                    secondMax = firstMax;
                    firstMax = j;
                }
                else if(secondMax == -1 || prev[j] > prev[secondMax]) {
                    secondMax = j;
                }
            }

            for(int j = 0; j < n; j++) {
                if(j != firstMax) curr[j] = mat[i][j] + prev[firstMax];
                else curr[j] = mat[i][j] + prev[secondMax];

                if(i == 0) max = Math.max(max, curr[j]);
            }

            int[] temp = curr;
            curr = prev;
            prev = temp;
        }
        return max;
    }
}
