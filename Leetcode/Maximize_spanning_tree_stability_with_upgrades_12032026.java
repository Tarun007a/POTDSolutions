package Leetcode;

// leetcode - 3600
// tc - O(log max * n), sc - O(n)
class Solution {
    class DSU {
        int[] parent;
        int[] size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            }
            else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            components--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 0, right = 0;
        int ans = -1;

        for (int[] e : edges) right = Math.max(right, e[2] * 2);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return ans;
    }

    // we cannot do this in one loop as think like if there are 2 edges which are connected
    // by a mandatory edge but it is present afterward and you may use and exaust you
    // doubling power
    private boolean isPossible(int n, int[][] edges, int k, int target) {
        DSU dsu = new DSU(n);
        int upgrades = 0;

        // mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;
                if (!dsu.union(u, v)) return false;   // no cycle
            }
        }

        // optional edges without upgrade
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s >= target) dsu.union(u, v);
        }

        // optional edges with upgrade
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s < target && s * 2 >= target) {
                if (dsu.find(u) != dsu.find(v)) {
                    if (upgrades == k) break;
                    upgrades++;
                    dsu.union(u, v);
                }
            }
        }

        return dsu.components == 1;
    }
}
