package Leetcode;

// you can use binary search on answer or dijkstra both are easy
// using dijkstra
class Solution {
    class Trio{
        int row;
        int col;
        int value;
        public Trio(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Trio> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        pq.add(new Trio(0, 0, grid[0][0]));
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        boolean[][] isVisited = new boolean[n][m];
        isVisited[0][0] = true;

        while(!pq.isEmpty()){
            Trio node = pq.remove();
            if(node.row == n-1 && node.col == m-1) return node.value;
            isVisited[node.row][node.col] = true;

            for(int i = 0; i < 4; i++){
                int newRow = node.row + delRow[i];
                int newCol = node.col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !isVisited[newRow][newCol]){
                    pq.add(new Trio(newRow, newCol, Math.max(node.value, grid[newRow][newCol])));
                }
            }
        }
        return -1;
    }
}

