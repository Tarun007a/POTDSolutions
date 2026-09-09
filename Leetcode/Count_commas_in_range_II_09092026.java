package Leetcode;

// tc - log(n), sc - O(1)
class Solution {
    public long countCommas(long num) {
        if(num < 1000) return 0;
        long result = 0;

        long prev = 999;
        long curr = 9999;

        while(curr <= num) {
            long count = curr - prev;

            long digits = 0;
            long temp = curr;
            while(temp != 0) {
                digits++;
                temp /= 10;
            }

            result += count * ((digits-1)/3);

            prev = curr;
            curr *= 10;
            curr += 9;
        }

        long count = num - prev;

        long digits = 0;
        long temp = curr;
        while(temp != 0) {
            digits++;
            temp /= 10;
        }

        result += count * ((digits-1)/3);
        return result;
    }
}
