package GFG;

// tc - O(logmax * m * logn), sc - O(1)
class Solution {
    private int getDonuts(int time, int n, int rank){
        int lo = 0;
        int hi = n;
        int result = 0;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int curr = rank * ((mid * (mid+1))/2);

            if(curr <= time){
                lo = mid+1;
                result = mid;
            }
            else hi = mid-1;
        }
        return result;
    }

    private boolean isPossible(int n, int time, int[] ranks){
        int result = 0;

        for(int rank : ranks){
            result += getDonuts(time, n, rank);
        }
        return result >= n;
    }

    public int minTime(int[] ranks, int n) {
        int m = ranks.length;
        int result = 0;
        int lo = 0;
        int hi = ranks[0] * ((n * (n+1))/2);

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isPossible(n, mid, ranks)){
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }
}
