package Leetcode;

// leetcode 717
// tc - O(n), sc - O(1)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;

        for(int i = 0; i < n-1; i++) {
            if(bits[i] == 1){
                if(i == n-2) return false;
                i++;
            }
        }
        return true;
    }
}