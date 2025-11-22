package GFG;

class Solution {
    public int minConnect(int n, int[][] edges) {
        if (edges.length < n - 1) return -1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                bfs(i, graph, visited);
            }
        }

        return components - 1;
    }

    private void bfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
