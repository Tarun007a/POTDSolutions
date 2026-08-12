package GFG;

// tc - O(n*n), sc - O(n*n)
class Solution {
    int mod = 1000000007;
    int n;

    Pair[][] dp;

    class Pair {
        int ways;
        int max;

        public Pair(int ways, int max) {
            this.ways = ways;
            this.max = max;
        }
    }

    private Pair helper(int i, int j, int[][] grid) {
        if(i == n-1 && j == n-1) {
            return new Pair(1, grid[i][j]);
        }

        if(dp[i][j] != null) return dp[i][j];

        int val = grid[i][j];

        if(val == 1) {
            if(j == n-1) return dp[i][j] = new Pair(0, -10000000);
            Pair p = helper(i, j+1, grid);

            Pair curr = new Pair(p.ways, p.max);
            curr.max = curr.max + val;

            return dp[i][j] = curr;
        }
        else if(val == 2) {
            if(i == n-1) return dp[i][j] = new Pair(0, -10000000);
            Pair p = helper(i+1, j, grid);

            Pair curr = new Pair(p.ways, p.max);
            curr.max = curr.max + val;

            return dp[i][j] = curr;
        }

        if(j == n-1) {
            Pair p = helper(i+1, j, grid);

            Pair curr = new Pair(p.ways, p.max);
            curr.max = curr.max + val;

            return dp[i][j] = curr;
        }

        if(i == n-1) {
            Pair p = helper(i, j+1, grid);

            Pair curr = new Pair(p.ways, p.max);
            curr.max = curr.max + val;

            return dp[i][j] = curr;
        }

        Pair p1 = helper(i, j+1, grid);
        Pair p2 = helper(i+1, j, grid);

        return dp[i][j] = new Pair((p1.ways + p2.ways) % mod, Math.max(p1.max, p2.max) + val);
    }

    public ArrayList<Integer> findWays(int[][] grid) {
        n = grid.length;
        dp = new Pair[n][n];

        Pair p = helper(0, 0, grid);

        ArrayList<Integer> result = new ArrayList<>();

        result.add(p.ways);

        if(p.ways != 0) result.add(p.max);
        else result.add(0);

        return result;
    }
}

