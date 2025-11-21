package GFG;

// tc - O(E log v), sc - O(v + e)
class Solution {
    static class Pair {
        int node, dist;
        Pair(int n, int d){
            node = n;
            dist = d;
        }
    }

    private int[] dijkstra(int V, List<List<Pair>> graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int d = cur.dist;

            if (d > dist[u]) continue;

            for (Pair p : graph.get(u)) {
                int v = p.node;
                int w = p.dist;

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w1 = e[2];

            graph.get(u).add(new Pair(v, w1));
            graph.get(v).add(new Pair(u, w1));
        }

        // Dijkstra from a and b using straight edges only
        // so we get shortest dist between a to all vertex
        // and then from b to all vertex
        // at the end try a to x, x to y(using curved), y to b
        int[] distA = dijkstra(V, graph, a);
        int[] distB = dijkstra(V, graph, b);

        int ans = distA[b];

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w2 = e[3];

            if (distA[u] != Integer.MAX_VALUE && distB[v] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[u] + w2 + distB[v]);

            if (distA[v] != Integer.MAX_VALUE && distB[u] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[v] + w2 + distB[u]);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}