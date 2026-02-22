package Leetcode;

// leetcode - 868
// tc - O(logn), sc - O(1)
class Solution {
    public int binaryGap(int n) {
        int maxStreak = 0;
        int currStreak = 0;

        while(n != 0 && n % 2 == 0) n /= 2;

        n /= 2;
        while(n != 0) {
            if(n % 2 == 1) {
                maxStreak = Math.max(maxStreak, currStreak+1);
                currStreak = 0;
            }
            else currStreak++;
            n /= 2;
        }
        return maxStreak;
    }
}