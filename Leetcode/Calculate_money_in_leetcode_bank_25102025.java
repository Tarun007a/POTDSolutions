package Leetcode;

// leetcode - 1716
// tc - O(1), sc - O(1)

// for every week the money increases by 7 and start from 28
// formula for sum of ap
// n/2(2*a + (n-1)*d);
// d is 7
class Solution {
    public int totalMoney(int n) {
        int a = 28;     // start digit of ap -> a
        int ele = n/7;  // total elements in ap

        int sum = (ele*((2*a)+(ele-1)*7))/2;
        ele++;
        for(int i = 0; i < n%7; i++)sum += ele++;
        return sum;
    }
}
