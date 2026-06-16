package Leetcode;

// leetcode - 3558
class Solution {
    private static final int MOD = 1000000007;

    private int dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        int maxDepth = 0;

        for (int child : adj.get(node)) {
            if (visited[child]) continue;

            visited[child] = true;
            maxDepth = Math.max(maxDepth, dfs(child, adj, visited));
        }

        return maxDepth + 1;
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp%2) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int depth = dfs(1, adj, visited);

        // depth = number of nodes on path
        // edges on path = depth - 1
        // answer = 2^(edges-1) = 2^(depth-2)
        return (int) power(2, depth - 2);
    }
}