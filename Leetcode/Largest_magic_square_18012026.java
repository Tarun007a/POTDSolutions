package Leetcode;

// leetcode - 1895
// tc - O(min(n,m) * n*m*(n+m)), sc - O(n*m)
class Solution {
    private boolean isMagic(int row, int col, int k, int[][] rowSum, int[][] colSum, int[][] grid){
        int reqSum = rowSum[row][col+k-1];
        if(col > 0) reqSum -= rowSum[row][col-1];

        for(int i = row; i < row+k; i++){
            int currSum = rowSum[i][col+k-1];
            if(col > 0) currSum -= rowSum[i][col-1];
            if(reqSum != currSum) return false;
        }

        for(int j = col; j < col+k; j++){
            int currSum = colSum[row+k-1][j];
            if(row > 0) currSum -= colSum[row-1][j];
            if(currSum != reqSum) return false;
        }

        int dia1 = 0;
        int dia2 = 0;
        int dia1Row = row;
        int dia1Col = col;
        int dia2Row = row;
        int dia2Col = col+k-1;

        for(int i = 0; i < k; i++){
            dia1 += grid[dia1Row++][dia1Col++];
            dia2 += grid[dia2Row++][dia2Col--];
        }

        if(dia1 != reqSum || dia2 != reqSum) return false;

        return true;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 1;

        int[][] rowSum = new int[n][m];
        int[][] colSum = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rowSum[i][j] += grid[i][j];
                if(j != 0) rowSum[i][j] += rowSum[i][j-1];

                colSum[i][j] += grid[i][j];
                if(i != 0) colSum[i][j] += colSum[i-1][j];
            }
        }

        for(int k = Math.min(n, m); k > 1; k--){
            for(int row = 0; row <= n-k; row++){
                for(int col = 0; col <= m-k; col++){
                    if(isMagic(row, col, k, rowSum, colSum, grid)) return k;
                }
            }
        }
        return 1;
    }
}
