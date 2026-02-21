package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    private boolean isPossible(int h, int[] citations){
        int count = 0;
        for(int citation : citations) count += citation >= h ? 1 : 0;
        return count >= h;
    }

    public int hIndex(int[] citations) {
        int result = 0;
        int hi = citations.length;
        int lo = 0;

        while(lo <= hi){
            int mid = lo - (lo - hi)/2;

            if(isPossible(mid, citations)){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }
}