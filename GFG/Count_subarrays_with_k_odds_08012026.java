package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int countSubarrays(int[] arr, int k) {
        int n = arr.length;
        int odds = 0;
        int prev = 0;
        int result = 0;
        int j = -1;

        for(int i = 0; i < n; i++){
            if((arr[i]&1) == 1) odds++;

            while(odds > k){
                if((arr[prev]&1) == 1) odds--;
                prev++;
            }
            if(odds == k){
                if(j < prev){
                    j = prev;
                    for(; ; j++) if((arr[j]&1) == 1) break;
                }
                result += j-prev+1;
            }
        }
        return result;
    }
}