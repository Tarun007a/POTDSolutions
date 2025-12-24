package GFG;

// tc - O(logn), sc - O(1)
class Solution {
    private int getPivot(int[] arr){
        int n = arr.length;
        int lo = 0;
        int hi = n-1;
        int result = 0;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > arr[n-1]){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }

    private int getSmaller(int lo, int hi, int val, int[] arr){
        int lower = lo;
        int result = -1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] <= val){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }

        if(result == -1) return 0;
        return result - lower + 1;
    }

    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = getPivot(arr);
        return getSmaller(0, pivot, x, arr) + getSmaller(pivot+1, n-1, x, arr);
    }
}
