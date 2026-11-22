package Leetcodecontest.weekly529;

class Solution {
    class Pair {
        int node;
        long time;

        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> {
                    if(a.time < b.time) return -1;
                    return 1;
                });

        long[] result = new long[n];
        boolean[] isVisited = new boolean[n];

        Arrays.fill(result, -1);

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        isVisited[0] = true;
        result[0] = 0;

        for(Pair p : adj.get(0)) {
            pq.add(p);
        }

        while(!pq.isEmpty()) {
            Pair p = pq.remove();

            requiredSignals[p.node]--;

            if(requiredSignals[p.node] == 0) {
                isVisited[p.node] = true;
                result[p.node] = p.time;

                for(Pair child : adj.get(p.node)) {
                    if(!isVisited[child.node]) {
                        pq.add(new Pair(child.node, p.time + child.time));
                    }
                }
            }
        }
        return result;
    }
}























