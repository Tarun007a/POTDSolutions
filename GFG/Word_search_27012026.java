package GFG;

// tc - (n*m*3^k)
class Solution {
    int n;
    int m;
    int k;
    private boolean isPossible(int i, int j, int idx, String word, char[][] mat, boolean[][] isVisited){
        if(idx == k) return true;
        if(i < 0 || i >= n || j < 0 || j >= m) return false;

        if(isVisited[i][j]) return false;
        isVisited[i][j] = true;

        if(mat[i][j] == word.charAt(idx)){
            boolean up = isPossible(i-1, j, idx+1, word, mat, isVisited);
            boolean down = isPossible(i+1, j, idx+1, word, mat, isVisited);
            boolean left = isPossible(i, j-1, idx+1, word, mat, isVisited);
            boolean right = isPossible(i, j+1, idx+1, word, mat, isVisited);

            isVisited[i][j] = false;
            return up || down || left || right;
        }
        isVisited[i][j] = false;
        return false;
    }
    public boolean isWordExist(char[][] mat, String word) {
        n = mat.length;
        m = mat[0].length;
        k = word.length();

        boolean[][] isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isPossible(i, j, 0, word, mat, isVisited)) return true;
            }
        }
        return false;
    }
}