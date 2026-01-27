package Leetcodecontest.weekly486;

class Solution {
    private boolean isTriplet(int[] arr){
        return (arr[0]*arr[0] + arr[1]*arr[1]) == arr[2]*arr[2];
    }

    private void fill(int node, ArrayList<ArrayList<Integer>> adj, int idx, int n, int[][] dist){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        boolean[] isVisited = new boolean[n];

        int curr = 0;
        isVisited[node] = true;

        while(!q.isEmpty()){
            int count = q.size();

            for(int i = 0; i < count; i++){
                int currNode = q.remove();
                dist[currNode][idx] = curr;
                for(int child : adj.get(currNode)){
                    if(!isVisited[child]) q.add(child);
                    isVisited[child] = true;
                }
            }
            curr++;
        }
    }

    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        int result = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // System.out.println(adj);

        int[][] dist = new int[n][3];

        fill(x, adj, 0, n, dist);
        fill(y, adj, 1, n, dist);
        fill(z, adj, 2, n, dist);

        // for(int[] arr : dist) System.out.println(Arrays.toString(arr));

        for(int i = 0; i < n; i++){
            int[] distances = {dist[i][0], dist[i][1], dist[i][2]};
            Arrays.sort(distances);

            if(isTriplet(distances)) result++;
        }

        return result;
    }
}
