package GFG;

// tc - O(logn), sc - O(1)
class Solution {
    private int getMissing(int idx, int[] arr){
        return arr[idx] - idx - 1;
    }

    public int kthMissing(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length-1;
        int result = 0;

        int missing = getMissing(0, arr);
        if(missing >= k) return k;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            missing = getMissing(mid, arr);
            if(missing >= k) hi = mid-1;
            else{
                result = mid;
                lo = mid+1;
            }
        }

        missing = getMissing(result, arr);
        return arr[result] + (k - missing);
    }
}
