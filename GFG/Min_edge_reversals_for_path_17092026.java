package GFG;

// works well and passes but we cannot promise tc - O(n + m) as
// single node may go in multiple times
// class Solution {
//     class Pair {
//         int node;
//         int val;

//         public Pair(int node, int val) {
//             this.node = node;
//             this.val = val;
//         }
//     }

//     public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
//         List<List<Pair>> adj = new ArrayList<>();
//         Queue<Pair> q = new ArrayDeque<>();
//         int[] cost = new int[n+1];
//         int result = Integer.MAX_VALUE;

//         cost[src] = 0;
//         Arrays.fill(cost, Integer.MAX_VALUE);
//         for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());

//         for(int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];

//             adj.get(u).add(new Pair(v, 0));
//             adj.get(v).add(new Pair(u, 1));
//         }

//         q.add(new Pair(src, 0));

//         while(!q.isEmpty()) {
//             Pair curr = q.remove();

//             if(curr.node == dst) {
//                 result = Math.min(result, curr.val);
//                 continue;
//             }

//             for(Pair child : adj.get(curr.node)) {
//                 int newNode = child.node;
//                 int newCost = curr.val + child.val;

//                 if(cost[newNode] > newCost) {
//                     q.add(new Pair(newNode, newCost));
//                     cost[newNode] = newCost;
//                 }
//             }
//         }

//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
// }






// CHAT-GPT
// Better approach: 0-1 BFS Use a Deque

// if (child.val == 0) dq.addFirst(new Pair(newNode, newCost));
// else dq.addLast(new Pair(newNode, newCost));

// This is the key property of 0-1 BFS:
// Edge weight 0 → process immediately → front
// Edge weight 1 → process later → back
// Then each edge is processed in amortized constant time.

class Solution {
    class Pair {
        int node;
        int val;

        public Pair(int node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair(v, 0));
            adj.get(v).add(new Pair(u, 1));
        }

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();

        cost[src] = 0;
        dq.addFirst(src);

        while (!dq.isEmpty()) {
            int node = dq.removeFirst();

            if (node == dst) {
                return cost[node];
            }

            for (Pair edge : adj.get(node)) {
                int newNode = edge.node;
                int newCost = cost[node] + edge.val;

                if (newCost < cost[newNode]) {
                    cost[newNode] = newCost;

                    if (edge.val == 0) dq.addFirst(newNode);
                    else dq.addLast(newNode);
                }
            }
        }

        return -1;
    }
}

