package GFG;

// tc - O(n*m), sc - O(n*m)
class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                mat[i][j] += mat[i][j-1];
            }
        }

        for(int j = 0; j < m; j++){
            for(int i = 1; i < n; i++){
                mat[i][j] += mat[i-1][j];
            }
        }

        for(int[] query : queries){
            int stRow = query[0];
            int stCol = query[1];
            int endRow = query[2];
            int endCol = query[3];

            int curr = mat[endRow][endCol];
            if(stRow > 0) curr -= mat[stRow-1][endCol];
            if(stCol > 0) curr -= mat[endRow][stCol-1];
            if(stRow > 0 && stCol > 0) curr += mat[stRow-1][stCol-1];

            result.add(curr);
        }
        return result;
    }
}
