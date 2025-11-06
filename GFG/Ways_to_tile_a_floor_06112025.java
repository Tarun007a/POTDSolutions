package GFG;

// tc - O(n), sc O(1)
class Solution {
    public int numberOfWays(int n) {
        if(n == 1) return 1;
        int prev = 2;
        int pp = 1;

        for(int i = 3; i <= n; i++){
            int curr = prev + pp;
            pp = prev;
            prev = curr;
        }
        return prev;
    }
};