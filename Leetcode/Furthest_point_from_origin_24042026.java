package Leetcode;

// leetcode - 2833
// tc - O(n), sc - O(1)
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int currLeft = 0;
        int currRight = 0;

        for(char move : moves.toCharArray()) {
            if(move == 'L') {
                currLeft++;
                currRight--;
            }
            else if(move == 'R') {
                currRight++;
                currLeft--;
            }
            else {
                currLeft++;
                currRight++;
            }
        }
        return Math.max(currLeft, currRight);
    }
}