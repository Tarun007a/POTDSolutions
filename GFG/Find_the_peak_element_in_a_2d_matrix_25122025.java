package GFG;

// tc - O(n*m), sc - O(1)
class Solution {
    private boolean isPeak(int row, int col, int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        if(row > 0){
            if(mat[row-1][col] > mat[row][col]) return false;
        }
        if(row != n-1){
            if(mat[row+1][col] > mat[row][col]) return false;
        }
        if(col > 0){
            if(mat[row][col-1] > mat[row][col]) return false;
        }
        if(col != m-1){
            if(mat[row][col+1] > mat[row][col]) return false;
        }

        return true;
    }

    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isPeak(i, j, mat)){
                    return new ArrayList<>(Arrays.asList(i, j));
                }
            }
        }
        return new ArrayList<>(Arrays.asList());
    }
}