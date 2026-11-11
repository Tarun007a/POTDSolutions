package Leetcode;

// leetcode - 3789
// tc - O(1), sc - O(1)
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(costBoth <= cost1 && costBoth <= cost2) {
            return (long)Math.max(need1, need2) * costBoth;
        }

        if(cost1 + cost2 >= costBoth) {
            int min = Math.min(need1, need2);
            long result = (long)min * costBoth;

            result += (cost1 <= costBoth) ? (long)cost1 * (need1 - min) : (long)costBoth * (need1 - min);

            result += (cost2 <= costBoth) ? (long)cost2 * (need2 - min) : (long)costBoth * (need2 - min);

            return result;
        }

        else {
            return (long)cost1 * need1 + (long)cost2 * need2;
        }
    }
}
