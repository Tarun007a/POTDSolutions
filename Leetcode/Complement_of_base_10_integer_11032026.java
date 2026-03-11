package Leetcode;

// leetcode - 1009
// tc - O(logn), sc - O(1)
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int result = 0;
        int pow = 0;

        while (n != 0) {
            if (n%2 == 0) result += Math.pow(2, pow);
            n /= 2;
            pow++;
        }
        return result;
    }
}