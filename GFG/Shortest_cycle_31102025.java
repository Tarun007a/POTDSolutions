package GFG;

// tc - v*O(V+E) sc - O(V + E)
class Solution {
    private class Pair{
        int node;
        int prev;
        public Pair(int node, int prev){
            this.node = node;
            this.prev = prev;
        }
    }

    private int helper(int st, int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] isVisited = new boolean[v];
        int[] cost = new int[v];
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(st, -1));
        cost[st] = 0;
        isVisited[st] = true;

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int node = curr.node;
            int prev = curr.prev;
            int currCost = cost[node];

            for(int child : adj.get(node)){
                if(child == prev) continue;
                if(isVisited[child]) return currCost + cost[child] + 1;

                isVisited[child] = true;
                cost[child] = currCost + 1;
                q.add(new Pair(child, node));
            }
        }
        return 100000;
    }

    public int shortCycle(int n, int[][] edges) {
        int result = 100000;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0; i < n; i++){
            result = Math.min(result, helper(i, n, adj));
        }
        return (result == 100000 ? -1 : result);
    }
}
