package GFG;

// tc - O(n^2 * log(n^2)), sc - O(n^2)
class Solution {
    class DSU{
        int[] parent;
        int[] size;
        int components;

        public DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            components = n;
            for(int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        private int findUPar(int i) {
            if(parent[i] == i) return i;

            return parent[i] = findUPar(parent[i]);
        }

        private boolean union(int i, int j) {
            int parI = findUPar(i);
            int parJ = findUPar(j);

            if(parI == parJ) return false;

            if(size[parI] >= size[parJ]) {
                parent[parJ] = parI;
                size[parI] += size[parJ];
            }
            else {
                parent[parI] = parJ;
                size[parJ] += size[parI];
            }
            components--;
            return true;
        }
    }

    class Edge {
        int u;
        int v;
        int x1;
        int y1;
        int x2;
        int y2;
        int dist;

        public Edge(int u, int v,int x1, int y1, int x2, int y2) {
            this.u = u;
            this.v = v;
            dist = Math.abs(x1-x2) + Math.abs(y1-y2);
        }
    }

    public int minCost(int[][] houses) {
        int n = houses.length;
        int cost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.dist-b.dist);

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                pq.add(new Edge(i, j, houses[i][0], houses[i][1], houses[j][0], houses[j][1]));
            }
        }

        DSU dsu = new DSU(n);

        while(dsu.components > 1) {
            Edge edge = pq.remove();

            if(dsu.union(edge.u, edge.v)) {
                cost += edge.dist;
            }
        }
        return cost;
    }
}
