package GFG;

// tc - O(n log n), sc - O(n)
class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int l = Math.max(0, i - arr[i]);
                int r = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{l, r});
            }
        }

        intervals.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int count = 0;
        int currEnd = 0;
        int i = 0;

        while (currEnd < n) {
            int farthest = currEnd - 1;

            while (i < intervals.size() && intervals.get(i)[0] <= currEnd) {
                farthest = Math.max(farthest, intervals.get(i)[1]);
                i++;
            }

            if (farthest < currEnd) return -1;

            count++;
            currEnd = farthest + 1;
        }

        return count;
    }
}

