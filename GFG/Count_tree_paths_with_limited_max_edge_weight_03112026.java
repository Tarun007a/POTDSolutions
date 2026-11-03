package GFG;

// tc - O(nlogn + qlogq + q + n), sc - O(n)
class Solution {
    class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    class DSU {
        int n;
        int[] size;
        int[] parent;

        public DSU(int n) {
            n++;                // question follows 1 based indexing
            this.n = n;
            size = new int[n];
            parent = new int[n];

            for(int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        private int findUPar(int i) {
            if(parent[i] == i) return i;

            return parent[i] = findUPar(parent[i]);
        }

        public int getSize(int i) {
            return size[findUPar(i)];
        }

        public void union(int i, int j) {
            int par1 = findUPar(i);
            int par2 = findUPar(j);

            if(par1 > par2) {
                size[par1] += size[par2];
                parent[par2] = par1;
            }
            else {
                size[par2] += size[par1];
                parent[par1] = par2;
            }
        }
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        int q = queries.length;
        int m = edges.length;
        int curr = 0;
        int idx = 0;

        DSU dsu = new DSU(n);
        ArrayList<Pair> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < q; i++) {
            list.add(new Pair(i, queries[i]));
            result.add(0);
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        Collections.sort(list, (a, b) -> a.val - b.val);

        for(Pair p : list) {
            int val = p.val;

            while(idx < m && edges[idx][2] <= val) {
                int u = edges[idx][0];
                int v = edges[idx][1];

                int size1 = dsu.getSize(u);
                int size2 = dsu.getSize(v);

                curr += (size1 * size2);

                dsu.union(u, v);
                idx++;
            }
            result.set(p.idx, curr);
        }
        return result;
    }
}





















