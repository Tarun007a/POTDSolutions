package Leetcode;

// leetcode - 3650
// tc - O(mlog(m)), sc - O(n+m)
class Solution {
    static class Pair{
        int node;
        int cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, 2*cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] isVisited = new boolean[n];
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int node = pair.node;
            int cost = pair.cost;
            if(isVisited[node]) continue;
            isVisited[node] = true;

            if(node == n-1) return cost;

            for(Pair child : adj.get(node)){
                if(!isVisited[child.node]){
                    pq.add(new Pair(child.node, cost + child.cost));
                }
            }
        }
        return -1;
    }
}