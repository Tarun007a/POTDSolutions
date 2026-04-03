package GFG;

// tc - O(n*m), sc - O(1)
class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<Integer> result = new ArrayList<>();

        for(int j = 0; j < m; j++) {
            int row = 0;
            int col = j;

            while(row < n && col >= 0) {
                result.add(mat[row][col]);
                row++;
                col--;
            }
        }

        for(int i = 1; i < n; i++) {
            int row = i;
            int col = m-1;

            while(row < n && col >= 0) {
                result.add(mat[row][col]);
                row++;
                col--;
            }
        }
        return result;
    }
}
