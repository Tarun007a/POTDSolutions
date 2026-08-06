package GFG;

// tc - O(ElogV), sc - O(V + E)
class Solution {
    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int shortestPath(int V, int src, int dest, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        int[] visited = new int[V];
        Arrays.fill(visited, -1);

        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost));
        }

        pq.add(new Pair(src, 0));
        visited[src] = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            int node = curr.node;
            int cost = curr.cost;

            if(node == dest) return cost;

            for(Pair p : adj.get(node)) {
                if(visited[p.node] == -1 || visited[p.node] > cost + p.cost) {
                    visited[p.node] = cost + p.cost;
                    pq.add(new Pair(p.node, cost + p.cost));
                }
            }
        }
        return -1;
    }
}

