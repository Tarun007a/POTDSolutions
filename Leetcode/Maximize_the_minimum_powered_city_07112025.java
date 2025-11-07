package Leetcode;

// leetcode - 2528
// tc - O(nlogc)  c is 100000000000, sc - O(n)
class Solution {
    private boolean isPossible(long req, long[] power, int r, int k){
        int n = power.length;
        long added = 0;
        long[] substract = new long[n];

        for(int i = 0; i < n; i++){
            added += substract[i];
            long curr = added + power[i];
            if(curr >= req) continue;

            long need = req - curr;
            if(need > k) return false;
            k -= need;
            added += need;
            int subIdx = i + 2*r + 1;
            if(subIdx < n) substract[subIdx] -= need;
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long lo = 0l;
        long hi = 100000000000l;
        long result = 0;

        long[] power = new long[n];

        long curr = 0;
        for(int i = 0; i < n; i++){
            curr += stations[i];
            if(i > r) curr -= stations[i-r-1];

            power[i] = curr;
        }

        curr = 0;
        for(int i = n-1; i >= 0; i--){
            if(i < n-r-1) curr -= stations[i+r+1];
            power[i] += curr;
            curr += stations[i];
        }

        while(lo <= hi){
            long mid = lo - (lo-hi)/2;
            if(isPossible(mid, power, r, k)){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }

        return result;
    }
}