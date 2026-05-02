package GFG;

// tc - O(logn), sc - O(1)
class Solution {
    public int findPosition(int n) {
        if((n&(n-1)) != 0) return -1;

        int result = 0;

        while(n != 0) {
            result++;
            n = n>>1;
        }
        return result;
    }
}