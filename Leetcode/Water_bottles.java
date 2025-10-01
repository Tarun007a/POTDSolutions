package Leetcode;

// leetcode - 1518
// tc - O(logn)
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int currEmpty = 0;
        int total = 0;
        int filled = numBottles;

        while(filled > 0){
            total += filled;
            currEmpty += filled;
            filled = currEmpty / numExchange;
            currEmpty = currEmpty % numExchange;
        }
        return total;
    }
}