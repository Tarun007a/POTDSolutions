package GFG;

class Solution {
    private class Pair{
        int node;
        int cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    private int dfs(int node, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj, int[] result){
        int max = 0;
        int secMax = 0;

        for(int child : adj.get(node)){
            if(!isVisited[child]){
                isVisited[child] = true;
                int curr = dfs(child, isVisited, adj, result)+1;
                if(curr > max){
                    secMax = max;
                    max = curr;
                }
                else secMax = Math.max(curr, secMax);
            }
        }

        result[0] = Math.max(result[0], max+secMax);
        return max;
    }

    public int diameter(int v, int[][] edges) {
        boolean[] isVisited = new boolean[v];
        int max = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < v; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                int[] result = new int[1];
                dfs(i, isVisited, adj, result);   // visit full component
                max = Math.max(max, result[0]);
            }
        }
        return max;
    }
}
