package Leetcode;

// tc - O(n), sc - O(1)
// leetcode - 3577
class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int freq = 0;
        long result = 1;
        long mod = 1000000007;
        int min = Integer.MAX_VALUE;

        for(int i : complexity){
            if(i == min) freq++;
            else if(min > i){
                freq = 1;
                min = i;
            }
        }

        if(freq > 1 || complexity[0] > min) return 0;

        for(int i = 2; i < n; i++) result = (result*i)%mod;

        return (int)result;
    }
}
