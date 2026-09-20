package Leetcodecontest.weekly520;

class Solution {
    private int binarySearch(int val, int lo, int[][] intervals) {
        int hi = intervals.length - 1;
        int result = 0;

        while(lo <= hi) {
            int mid = lo - (lo - hi) / 2;

            if(intervals[mid][0] <= val) {
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }

    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        long result = 0;

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0]-b[0];
        });

        for(int i = 0; i < n; i++) {
            int idx = binarySearch(intervals[i][1], i, intervals);
            // System.out.println(idx);
            result += (long)(idx - i);
        }
        return result;
    }
}