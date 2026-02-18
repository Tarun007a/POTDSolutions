package Leetcode;

// leetcode - 693
// tc c- O(logn), sc - O(1)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while(n != 0){
            int curr = n%2;
            n /= 2;
            if(prev == curr) return false;
            prev = curr;
        }
        return true;
    }
}
