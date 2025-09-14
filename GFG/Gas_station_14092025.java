package GFG;

// Using prefix and suffix sum is the first and most intutive way using o(n) time and O(n) space
// then as the question mentions that we can have only one answer so we can store the potential
// answer and then check it by a total sum this works in O(n) time and O(1) space
class Solution {
    public int startStation(int[] gas, int[] cost) {
        int total = 0, currTank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            currTank += diff;

            if (currTank < 0) {
                start = i + 1;   // new potential start
                currTank = 0;    // reset tank
            }
        }

        return total >= 0 ? start : -1;
    }
}
