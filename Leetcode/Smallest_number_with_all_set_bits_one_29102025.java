package Leetcode;

// leetcode - 3370
// tc - O(logn)
class Solution {
    public int smallestNumber(int n) {
        int lo = 1;
        int hi = 10;
        int result = 0;

        while(lo <= hi){
            int mid = lo-(lo-hi)/2;
            int curr = (1 << mid)-1;
            if(curr >= n){
                result = curr;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }
}
