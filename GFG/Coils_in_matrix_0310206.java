package GFG;

// tc - o(n*n), sc - O(n*n)
class Solution {
    int updateRow(int row, int dir) {
        if(dir == 0) return row+1;
        if(dir == 2) return row-1;
        return row;
    }

    int updateCol(int col, int dir) {
        if(dir == 1) return col+1;
        if(dir == 3) return col-1;
        return col;
    }

    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int m = 4*n;

        int[][] arr = new int[m][m];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = i * m + j + 1;
            }
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int row1 = -1;
        int col1 = 0;
        int row2 = m;
        int col2 = m-1;
        int val = m;
        boolean flag = true;
        int dir1 = 0;
        int dir2 = 2;

        while(val > 0) {
            for(int i = 0; i < val; i++) {
                row1 = updateRow(row1, dir1);
                col1 = updateCol(col1, dir1);
                row2 = updateRow(row2, dir2);
                col2 = updateCol(col2, dir2);

                list1.add(arr[row1][col1]);
                list2.add(arr[row2][col2]);
            }
            dir1 = (dir1+1) % 4;
            dir2 = (dir2+1) % 4;

            if(flag) {
                val -= 2;
                flag = false;
            }
            else flag = true;
        }

        result.add(list1);
        result.add(list2);
        return result;
    }
}