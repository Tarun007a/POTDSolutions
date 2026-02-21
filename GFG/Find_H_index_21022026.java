package GFG;

// tc - O(nlogn), sc - O(1)
// binary search on answer
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

// tc - O(n), sc - O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = Arrays.stream(citations).max().getAsInt();
        int result = 0;

        int[] freq = new int[max+1];

        for(int citation : citations) freq[citation]++;

        for(int i = max-1; i >= 0; i--) freq[i] += freq[i+1];

        for(int i = 0; i <= max; i++){
            if(freq[i] >= i) result = i;
        }
        return result;
    }
}