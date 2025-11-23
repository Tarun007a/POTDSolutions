package GFG;

// tc - O(n*n), sc - O(n)
class Solution {
    class DSU {
        int[] parent;
        int[] size;
        int components;

        public DSU(int n) {
            components = n;
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        private void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;

            components--;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            }
            else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }

    public int maxRemove(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }

        return n - dsu.components;
    }
}
