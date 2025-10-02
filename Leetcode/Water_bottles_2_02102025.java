package Leetcode;
// leetcode - 3100
// time complexity - O(n)
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottlesDrunk = 0;
        int empty = 0;

        while(numBottles > 0){
            bottlesDrunk += numBottles;
            empty += numBottles;
            numBottles = 0;
            if(empty >= numExchange){
                empty -= numExchange++;
                numBottles = 1;
            }
        }
        return bottlesDrunk;
    }
}