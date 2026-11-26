package Leetcode;

// leetcode - 3360
// tc - O(n), sc - O(1)
class Solution {
    public boolean canAliceWin(int n) {
        boolean ans = true;
        int remove = 10;

        while(n >= 0){
            n -= remove--;
            ans = !ans;
            if(n < 0)return ans;
        }
        return true;
    }
}