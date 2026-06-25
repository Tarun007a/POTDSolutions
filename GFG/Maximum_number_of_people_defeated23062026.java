package GFG;

class Solution {
    private long helper(long n) {
        return (n * (n+1) * (2*n+1))/6;
    }

    int maxPeopleDefeated(int p) {
        int low = 1;
        int hi = 964;
        long val = (long)p;
        int result = 0;

        while(low <= hi) {
            int mid = hi-(hi-low)/2;
            long sum = helper(mid);

            if(sum <= val) {
                result = mid;
                low = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }
};