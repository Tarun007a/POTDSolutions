package Leetcode;

// leetcode - 1594
// tc - O(n*m), sc - O(m)
class Solution {
    private static final long mod = (long)1e9 + 7l;
    class Pair{
        long min;
        long max;

        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }

        public String toString() {
            return min + " " + max;
        }
    }

    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Pair[] prev = new Pair[m];
        Pair[] curr = new Pair[m];

        prev[0] = new Pair(grid[0][0], grid[0][0]);
        for(int j = 1; j < m; j++) prev[j] = new Pair(prev[j-1].min * grid[0][j], prev[j-1].max * grid[0][j]);

        for(int i = 1; i < n; i++) {
            long ele = grid[i][0];
            if(ele >= 0) curr[0] = new Pair(prev[0].min * ele, prev[0].max * ele);
            else curr[0] = new Pair(prev[0].max * ele, prev[0].min * ele);

            for(int j = 1; j < m; j++) {
                ele = grid[i][j];
                if(ele >= 0) curr[j] = new Pair(Math.min(curr[j-1].min * ele, prev[j].min * ele), Math.max(curr[j-1].max * ele, prev[j].max * ele));
                else curr[j] = new Pair(Math.min(curr[j-1].max * ele, prev[j].max * ele), Math.max(curr[j-1].min * ele, prev[j].min * ele));
            }
            Pair[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[m-1].max >= 0 ? (int)(prev[m-1].max%mod) : -1;
    }
}
