package Leetcode;

// leetcode - 2054
// tc - O(nlogn), sc - O(n)
class Solution {
    private int getIdx(int time, int[][] events){
        int lo = 0;
        int hi = events.length-1;
        int result = 0;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(events[mid][0] > time){
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int result = 0;
        int[] maxAhead = new int[n];
        maxAhead[n-1] = events[n-1][2];

        for(int i = n-2; i >= 0; i--){
            maxAhead[i] = Math.max(maxAhead[i+1], events[i][2]);
        }

        for(int[] event : events){
            int end = event[1];
            int nextIdx = getIdx(end, events);
            if(nextIdx == 0) result = Math.max(result, event[2]);
            else result = Math.max(result, event[2] + maxAhead[nextIdx]);
        }
        return result;
    }
}