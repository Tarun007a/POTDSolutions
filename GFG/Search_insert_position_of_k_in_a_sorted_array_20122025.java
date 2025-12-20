package GFG;

// tc - O(logn), sc - O(1)
class Solution {
    public int searchInsertK(int arr[], int k) {
        int hi = arr.length - 1;
        int lo = 0;
        int result = 0;

        while(lo <= hi){
            int mid = lo - (lo-hi)/2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] < k){
                result = mid+1;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }
};
