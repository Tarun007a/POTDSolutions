package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    private boolean isBalance(int n, int d){
        int temp = n;
        int sum = 0;

        while(temp != 0){
            sum += temp % 10;
            temp /= 10;
        }
        return n - sum >= d;
    }

    public int getCount(int n, int d) {
        if(d == 0) return n;
        int lo = 0;
        int hi = n;
        int result = 0;

        while(lo <= hi){
            int mid = lo - (lo - hi) / 2;

            if(isBalance(mid, d)){
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        if(result == 0) return 0;
        return n - result + 1;
    }
};