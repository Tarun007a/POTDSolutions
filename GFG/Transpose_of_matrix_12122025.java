package GFG;

// tc - O(n*m), sc - O(1)
class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int j = 0; j < m; j++){
            ArrayList<Integer> curr = new ArrayList<>();

            for(int i = 0; i < n; i++){
                curr.add(mat[i][j]);
            }
            result.add(curr);
        }
        return result;
    }
}