package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int xor = 0;

        for(int i = 0; i < n; i++){
            if(((long)(i+1) * (n-i)) % 2 == 1) xor = xor ^ arr[i];
        }
        return xor;
    }
}
