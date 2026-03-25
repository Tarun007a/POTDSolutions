package GFG;

// tc - O(V + E), sc - O(V + E)
class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int[] degree = new int[V];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        int remainingNodes = V;

        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int neighbor : adj.get(node)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) q.add(neighbor);
                }
            }
        }

        while (!q.isEmpty()) result.add(q.poll());

        return result;
    }
}