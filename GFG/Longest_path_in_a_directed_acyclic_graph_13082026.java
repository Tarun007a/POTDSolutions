package GFG;

// tc - O(v+e), sc - O(v+e)
class Solution {
    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        int[] result = new int[V];
        Queue<Pair> q = new ArrayDeque<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        Arrays.fill(result, Integer.MIN_VALUE);

        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int cost = edge.get(2);

            adj.get(u).add(new Pair(v, cost));
        }

        q.add(new Pair(src, 0));
        result[src] = 0;

        while(!q.isEmpty()) {
            Pair curr = q.remove();

            for(Pair p : adj.get(curr.node)) {
                int node = p.node;
                int cost = curr.cost + p.cost;

                if(cost > result[node]) {
                    result[node] = cost;
                    q.add(new Pair(node, cost));
                }
            }
        }
        return result;
    }
}
