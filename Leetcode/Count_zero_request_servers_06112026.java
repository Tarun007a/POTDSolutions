package Leetcode;

// leetcode - 2747
// tc - O(mlogm + qlogq), sc - O(n + q)
class Solution {
    private class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q = queries.length;
        int m = logs.length;
        int idx1 = 0;
        int idx2 = 0;
        int[] result = new int[q];
        Pair[] pairs = new Pair[q];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < q; i++) pairs[i] = new Pair(i, queries[i]);

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        Arrays.sort(pairs, (a, b) -> a.val - b.val);

        for(int i = 0; i < q; i++) {
            int lo = pairs[i].val - x;
            int hi = pairs[i].val;

            // System.out.println(lo + " " + hi);

            while(idx2 < m && logs[idx2][1] <= hi) {
                int server = logs[idx2][0];
                mp.put(server, mp.getOrDefault(server, 0)+1);
                idx2++;
            }

            while(idx1 < m && logs[idx1][1] < lo) {
                int server = logs[idx1][0];
                mp.put(server, mp.get(server)-1);
                if(mp.get(server) == 0) mp.remove(server);
                idx1++;
            }

            // System.out.println(idx1 + " " + idx2);
            // System.out.println(mp);
            result[pairs[i].idx] = n - mp.size();
        }
        return result;
    }
}