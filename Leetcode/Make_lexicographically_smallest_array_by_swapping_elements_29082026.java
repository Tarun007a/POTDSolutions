package Leetcode;

// lc - 2948
// tc - O(nlogn), sc - O(n)
class Solution {
    private class Pair {
        int i;
        int val;

        public Pair(int i, int val) {
            this.i = i;
            this.val = val;
        }
    }

    private class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int getPar(int i) {
            if(parent[i] == i) return i;

            return parent[i] = getPar(parent[i]);
        }

        public void union(int i, int j) {
            int p1 = getPar(i);
            int p2 = getPar(j);

            if(p1 == p2) return;

            if(size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        HashMap<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(pairs, (a, b) -> a.val-b.val);

        DSU dsu = new DSU(n);
        for(int i = 1; i < n; i++) {
            if(pairs[i].val - pairs[i-1].val <= limit){
                dsu.union(pairs[i-1].i, pairs[i].i);
            }
        }

        for(int i = 0; i < n; i++) {
            int par = dsu.getPar(i);
            if(!mp.containsKey(par)) mp.put(par, new PriorityQueue<>());

            mp.get(par).add(nums[i]);
        }

        for(int i = 0; i < n; i++) {
            int par = dsu.getPar(i);

            nums[i] = mp.get(par).remove();
        }
        return nums;
    }
}

