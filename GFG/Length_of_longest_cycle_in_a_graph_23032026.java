package GFG;

// tc - O(V), sc - O(V)
class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] adjEdge = new int[V];

        Arrays.fill(adjEdge, -1);
        for(int[] edge : edges) adjEdge[edge[0]] = edge[1];

        boolean[] visited = new boolean[V];
        int[] timeVisited = new int[V];
        Arrays.fill(timeVisited, -1);

        int maxCycle = -1;

        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;

            int node = i;
            int time = 0;

            while (node != -1 && !visited[node]) {
                visited[node] = true;
                timeVisited[node] = time++;

                node = adjEdge[node];
            }

            if (node != -1 && timeVisited[node] != -1) {
                int cycleLength = time - timeVisited[node];
                maxCycle = Math.max(maxCycle, cycleLength);
            }

            node = i;
            while (node != -1 && timeVisited[node] != -1) {
                int next = adjEdge[node];
                timeVisited[node] = -1;
                node = next;
            }
        }

        return maxCycle;
    }
}
