package GFG;

// tc - O(n*m*k), sc - O(1)
class Solution {
    private boolean helper(int i, int j, int delRow, int delCol, String word, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int k = word.length();
        int idx = 0;

        while(idx != k) {
            if(i < 0 || j < 0 || i >= n || j >= m) return false;
            if(mat[i][j] != word.charAt(idx)) return false;

            idx++;
            i += delRow;
            j += delCol;
        }

        return true;
    }

    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                boolean flag = false;

                for(int delRow = -1; delRow < 2 && !flag; delRow++) {
                    for(int delCol = -1; delCol < 2 && !flag; delCol++) {
                        if(delRow == 0 && delCol == 0) continue;
                        if(helper(i, j, delRow, delCol, word, mat)) {
                            flag = true;
                        }
                    }
                }
                if(flag) result.add(new ArrayList<>(List.of(i, j)));
            }
        }
        return result;
    }
};
