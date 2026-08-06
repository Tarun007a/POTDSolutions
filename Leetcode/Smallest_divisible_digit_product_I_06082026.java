package Leetcode;

// leetcode - 3345
// tc - O(10 * logn), sc - O(1)
class Solution {
    private boolean isDivisible(int num, int t) {
        int product = 1;

        while(num != 0) {
            product *= num%10;
            num /= 10;
        }

        return (product % t == 0);
    }

    public int smallestNumber(int n, int t) {
        int num = n;

        while(!isDivisible(num, t)) num++;

        return num;
    }
}