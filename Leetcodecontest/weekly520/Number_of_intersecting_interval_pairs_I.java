package Leetcodecontest.weekly520;

class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int st1 = intervals[i][0];
                int end1 = intervals[i][1];

                int st2 = intervals[j][0];
                int end2 = intervals[j][1];

                if(end1 >= st2 && end1 <= end2) result++;
                else if(end2 >= st1 && end2 <= end1) result++;
            }
        }
        return result;
    }
}