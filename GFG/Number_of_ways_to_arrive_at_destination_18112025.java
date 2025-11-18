package GFG;

// tc - O(ElogV), sc - O(E + v)
class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[V];
        ways[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (int[] nei : graph.get(u)) {
                int v = nei[0];
                int w = nei[1];

                int newDist = d + w;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.add(new int[]{v, newDist});
                }
                else if (newDist == dist[v]) {
                    ways[v] = ways[v] + ways[u];
                }
            }
        }
        return ways[V - 1];
    }
}