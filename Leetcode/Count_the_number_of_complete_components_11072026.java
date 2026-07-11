package Leetcode;

// leetcode - 2685
// tc - O(n + m), sc - O(n + m)
class Solution {
    private int isComplete(int node, boolean[] isVisited,
                           List<List<Integer>> adj) {
        int countN = 0;
        int countE = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        isVisited[node] = true;

        while(!q.isEmpty()) {
            int curr = q.remove();

            countN++;
            countE += adj.get(curr).size();

            for(int child : adj.get(curr)) {
                if(!isVisited[child]) {
                    isVisited[child] = true;
                    q.add(child);
                }
            }
        }
        // System.out.println(countN + " " + countE);
        return (countN * (countN - 1) == countE) ? 1 : 0;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int result = 0;
        boolean[] isVisited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                result += isComplete(i, isVisited, adj);
            }
        }
        return result;
    }
}
