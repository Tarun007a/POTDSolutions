package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    private boolean isBalance(int time, int k, int[] arr){
        int curr = 0;
        k--;

        for(int i : arr){
            if(i > time) return false;

            curr += i;
            if(time < curr){
                k--;
                if(k < 0) return false;
                curr = i;
            }
        }

        return true;
    }

    public int minTime(int[] arr, int k) {
        int n = arr.length;
        int lo = 0;
        int hi = Arrays.stream(arr).sum();
        int result = 0;

        while(lo <= hi){
            int mid = lo - (lo - hi) / 2;
            if(isBalance(mid, k, arr)){
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }
}
