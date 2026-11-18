package GFG;

// tc - O(1), sc - O(1)
class Solution {
    int xorN(int n) {
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n+1;
        if(n % 4 == 3) return 0;

        return -1;   // never reached here
    }

    public int findXOR(int l, int r) {
        return xorN(l-1) ^ xorN(r);
    }
}