package Leetcode;

// leetcode - 1288
// tc - o(nlogn), sc - O(1)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int result = n;
        int prevEnd = -1;

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        for(int[] interval : intervals) {
            if(prevEnd >= interval[1]) result--;
            else prevEnd = interval[1];
        }
        return result;
    }
}