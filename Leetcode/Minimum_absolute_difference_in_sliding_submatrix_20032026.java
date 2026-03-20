package Leetcode;

// leetcode - 3567
// tc - O(n * m * k^2 * log k, sc - O(n * m + k^2)
class Solution {
    private int findMin(int row, int col, int k, int[][] grid){
        if(k == 1)return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = row; i < row+k; i++){
            for(int j = col; j < col+k; j++){
                int ele = grid[i][j];
                if(set.contains(ele))continue;
                pq.add(grid[i][j]);
                set.add(ele);
            }
        }

        int min = Integer.MAX_VALUE;
        int prev = pq.remove();
        if(pq.isEmpty())return 0;

        while(!pq.isEmpty()){
            min = Math.min(min, Math.abs(prev - pq.peek()));
            prev = pq.remove();
        }

        return min;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n-k+1][m-k+1];


        for(int i = 0; i < n-k+1; i++){
            for(int j = 0; j < m-k+1; j++){
                result[i][j] = findMin(i, j, k, grid);
            }
        }
        return result;
    }
}