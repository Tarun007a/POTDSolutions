package GFG;

// tc - O(logn), sc - O(1)
class Solution {
    int largestPowerOf2(int n) {
        int p = 0;
        while ((1 << (p + 1)) <= n) p++;
        return p;
    }

    int countSetBits(int n) {
        if (n == 0) return 0;

        int p = largestPowerOf2(n);

        int part1 = n - (1 << p) + 1;
        int part2 = p * (1 << (p - 1));
        int part3 = countSetBits(n - (1 << p));

        return part1 + part2 + part3;
    }
}
