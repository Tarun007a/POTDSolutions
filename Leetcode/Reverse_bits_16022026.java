package Leetcode;

// leetcode - 190
// tc - O(logn), sc - O(logn)
class Solution {
    public int reverseBits(int n) {
        int mask = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 32; i++){
            int curr = (n & mask) == 0 ? 0 : 1;
            sb.append(curr);
            mask = mask<<1;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
