package Leetcodecontest.weekly523;

class Solution {
    public boolean threeFibonacciSum(int n) {
        long n1 = n;
        long first = 0;
        long second = 1;
        long third = 1;

        while(true) {
            if(first + second + third == n1) return true;
            if(first + second + third > n1) return false;

            long next = second + third;
            first = second;
            second = third;
            third = next;
        }
    }
}