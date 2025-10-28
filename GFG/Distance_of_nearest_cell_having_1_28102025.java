package GFG;

// tc - O(n*m) sc - O(n*m)

class Solution {
    class Pair{
        int row;
        int col;
        int cost;
        public Pair(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<Pair> q = new ArrayDeque<>();
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0; i < n; i++){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                }
                curr.add(0);
            }
            result.add(curr);
        }

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int row = curr.row;
            int col = curr.col;
            int cost = curr.cost;

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && result.get(newRow).get(newCol) == 0){
                    result.get(newRow).set(newCol, cost+1);
                    q.add(new Pair(newRow, newCol, cost+1));
                }
            }
        }

        return result;
    }
}




