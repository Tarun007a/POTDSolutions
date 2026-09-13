package GFG;

// Approach - Find the diameter of tree and div by 2 in even case and
// for odd  div by 2 + 1,
// to find diameter we first find the farthest node
// from any random node (here 1) and then farthest node from that node to
// get diameter of the tree
// tc - O(n), sc - O(n)
class Solution {
    private class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    private Pair bfs(int node, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        Pair result = new Pair(node, 0);
        boolean[] isVisited = new boolean[n+1];
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(node, 0));
        isVisited[node] = true;

        while(!q.isEmpty()) {
            Pair curr = q.remove();

            if(curr.dist > result.dist) result = curr;

            for(int child : adj.get(curr.node-1)) {
                if(!isVisited[child]){
                    q.add(new Pair(child, curr.dist + 1));
                    isVisited[child] = true;
                }
            }
        }

        return result;
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        Pair first = bfs(1, adj);

        Pair second = bfs(first.node, adj);
        return (second.dist + 1) / 2;
    }
}
