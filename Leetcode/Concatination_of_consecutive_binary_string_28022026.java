package Leetcode;

// leetcode - 1680
// tc - O(nlogn), sc - O(logn)
class Solution {
    public int concatenatedBinary(int n) {
        long num = 1;
        int mod = (int)1e9 + 7;

        for(int i = 2; i <= n; i++){
            num = num << Integer.toBinaryString(i).length();
            num = num | i;
            num = num % mod;
        }
        return (int)num;
    }
}
