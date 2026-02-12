package GFG;

// tc - O((max+k) * log(n)), sc - O(n)
class Solution {
    private boolean isPossible(int h, int k, int w, int[] arr){
        int n = arr.length;
        int[] prefixSum = new int[n];
        int curr = 0;

        for(int i = 0; i < n; i++){
            curr += prefixSum[i];
            int requiredDays = h-arr[i]-curr;

            if(requiredDays <= 0)continue;

            int idx = i+w;
            if(i+w < n) prefixSum[idx] = -requiredDays;

            curr += requiredDays;
            k -= requiredDays;
            if(k < 0)return false;

        }
        return true;
    }

    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int result = 0;

        int hi = arr[0];
        int lo = arr[0];
        for(int i : arr){
            lo = Math.min(lo, i);
            hi = Math.max(hi, i);
        }
        hi += k+1;

        while(lo <= hi){
            int mid = lo+(hi-lo)/2;

            if(isPossible(mid, k, w, arr)){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }
}
