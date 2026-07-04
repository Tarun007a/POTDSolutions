package Leetcode;

// leetcode - 2492
// tc - o((n+m)log(n+m)) ~ Elog(v), sc - (n+m)
// class Solution {
//     class Pair {
//         int node;
//         int cost;

//         public Pair(int node, int cost) {
//             this.node = node;
//             this.cost = cost;
//         }
//     }

//     public int minScore(int n, int[][] roads) {
//         int result = 100000;
//         List<List<Pair>> adj = new ArrayList<>();
//         int[] visited = new int[n+1];
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

//         for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

//         for(int[] road : roads) {
//             int u = road[0];
//             int v = road[1];
//             int cost = road[2];

//             adj.get(u).add(new Pair(v, cost));
//             adj.get(v).add(new Pair(u, cost));
//         }

//         pq.add(new Pair(1, 0));
//         while(!pq.isEmpty()) {
//             Pair curr = pq.remove();
//             int node = curr.node;
//             int cost = curr.cost;

//             if(node == n) result = Math.min(result, cost);

//             for(Pair pair : adj.get(node)) {
//                 int v = pair.node;
//                 int newCost = pair.cost;
//                 if(cost != 0) newCost = Math.min(pair.cost, cost);

//                 if(visited[v] == 0 || visited[v] > newCost) {
//                     visited[v] = newCost;
//                     pq.add(new Pair(v, newCost));
//                 }
//             }
//         }
//         return result;
//     }
// }


// So here the answer is the minimum edge cost in the component to which 1 & n
// belong to also we are guranteed that there is a path from 1 to n, so 1 and n be
// so we not need dijkstra we need to do a simple bfs from 1 visit all the nodes
// in that component and then simply return as it is given that there always
// exist path from 1 to n, so they belong to same component.

// so just do a simple bfs and record the min cost among all the edges
// tc - O(n+m), sc - O(n)

class Solution {
    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minScore(int n, int[][] roads) {
        int result = 100000;
        List<List<Pair>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost));
        }

        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int node = q.remove();

            for(Pair pair : adj.get(node)) {
                int v = pair.node;

                // store the min cost along all the edges
                // this cannot be done out of this loop
                result = Math.min(result, pair.cost);

                if(!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        return result;
    }
}