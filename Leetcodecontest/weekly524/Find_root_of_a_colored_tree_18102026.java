package Leetcodecontest.weekly524;

class Solution {
    class Pair {
        int node;
        char color;

        public Pair(int node, char color) {
            this.node = node;
            this.color = color;
        }
    }

    private boolean bfs(int node, char color, List<List<Pair>> adj) {
        int n = adj.size();
        char[] order = {'R', 'B', 'W'};
        int colorIdx = 0;

        if(color == 'B') colorIdx = 1;
        else if(color == 'W') colorIdx = 2;

        boolean[] isVisited = new boolean[n];
        isVisited[node] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);

        while(!q.isEmpty()) {
            int m = q.size();
            colorIdx = (colorIdx+1) % 3;
            char curr = order[colorIdx];

            for(int i = 0; i < m; i++) {
                int val = q.remove();
                for(Pair p : adj.get(val)) {
                    if(isVisited[p.node]) continue;
                    isVisited[p.node] = true;
                    if(curr != p.color) return false;

                    q.add(p.node);
                }
            }
        }
        return true;
    }

    public int findColoredRoot(int[][] edges, String colors) {
        int n = colors.length();
        List<List<Pair>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(new Pair(v, colors.charAt(v)));
            list.get(v).add(new Pair(u, colors.charAt(u)));
        }

        for(int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();

            for(Pair child : list.get(i)) {
                set.add(child.color);
            }
            if(set.size() == 3) return -1;
        }

        for(int i = 0; i < n; i++) {
            int childs = list.get(i).size();

            if(childs == 3) continue;

            if(bfs(i, colors.charAt(i), list)) {
                return i;
            }
            // System.out.println();
        }
        return -1;
    }
}