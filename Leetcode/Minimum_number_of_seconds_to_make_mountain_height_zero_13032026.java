package Leetcode;

// leetcode - 3296

// tc - O(log(maxTime) * n * log(mountainHeight))
// maxTime = (long)workerTimes[0] * (((long)mountainHeight * (mountainHeight+1))/2)
// n = number of workers, log(mountainHeight) can be reduced to O(1) using maths
// by solving the eq,
// totalTime = w + w*2 + .... + w*x so total time required by w worker to reduce x height
// totalTime = w (1+2+...+3) -> w * ((x * (x+1))/2); and now we are using bs on answer
// so we will have totalTime and we need x, so solve the eq for x.
class Solution {
    private boolean canReduce(long height, long worker, long time) {
        return time >= worker * (height * (height + 1))/2;
    }

    private long totalReduce (long worker, long time, int mountainHeight) {
        int lo = 0;
        int hi = mountainHeight;
        long result = 0;

        while(lo <= hi) {
            int mid = lo - (lo - hi) / 2;

            if(canReduce(mid, worker, time)) {
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }

    private boolean isPossible(long time, int height, int[] workerTimes) {
        long curr = 0;

        for(int worker : workerTimes) {
            curr += totalReduce(worker, time, height);
            if(curr >= height) return true;
        }
        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long lo = 0;
        long hi = (long)workerTimes[0] * (((long)mountainHeight * (mountainHeight+1))/2);
        long result = 0;

        while (lo <= hi) {
            long mid = hi - (hi - lo) / 2;

            if(isPossible(mid, mountainHeight, workerTimes)) {
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }
}
