package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long res = 0;
        for(int i=0; i<17; i++){
            long c = 0;

            for(int num : arr){
                if((num & (1 << i)) != 0){
                    c++;
                }
            }
            long cf = n - c;
            res += c * cf *(1L <<i);
        }
        return res;
    }
}
