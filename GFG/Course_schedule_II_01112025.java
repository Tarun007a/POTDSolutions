package GFG;

class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.remove();
            result.add(node);

            for(int child : adj.get(node)){
                indegree[child]--;
                if(indegree[child] == 0) q.add(child);
            }
        }

        // System.out.println(result);

        if(result.size() != n) return new ArrayList<>();
        return result;
    }
}