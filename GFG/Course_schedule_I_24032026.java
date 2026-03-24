package GFG;

// tc - O(n + m), sc - O(n)
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int visited = 0;

        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];

            indegree[v]++;
            adj.get(u).add(v);
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            visited++;

            for(int course : adj.get(curr)) {
                indegree[course]--;
                if(indegree[course] == 0) q.add(course);
            }
        }
        return visited == n;
    }
}















