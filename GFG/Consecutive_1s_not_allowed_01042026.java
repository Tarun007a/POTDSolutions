package GFG;

// tc - O(n), sc - O(n) -> recsive call stack
class Solution {
    private int helper(int i, int n, int zero, int one) {
        if(i == n) return (zero + one);

        int newZero = zero + one;
        int newOne = zero;

        return helper(i+1, n, newZero, newOne);
    }
    int countStrings(int n) {
        return helper(1, n, 1, 1);
    }
}
