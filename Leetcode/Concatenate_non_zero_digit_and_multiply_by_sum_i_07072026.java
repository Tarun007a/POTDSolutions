package Leetcode;

// leetcode - 3754
// tc - O(logn), sc - O(1)
class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int num = 0;

        while(n != 0) {
            int digit = n % 10;
            n /= 10;
            if(digit != 0) num = num * 10 + digit;
            sum += digit;
        }

        while(num != 0) {
            int digit = num % 10;
            num /= 10;
            n = n * 10 + digit;
        }
        return (long)n * sum;
    }
}