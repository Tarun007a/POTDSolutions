package Leetcode;

// leetcode - 1689
// tc - O(n), sc - O(1)

// suppose we have 32, 45, 41, 40
/*
32          45                  41                  40

11          11                  11                  10
11          11                  10                  10
10          11                  10                  10
            11                  10                  10
            01 -> can say 1

we need to add these as we can have only 1's and 0's so to make any digit in a number we need that
number of 1's only as here for 32 we need 3 ons at that position and for 2 we need 2 1's, and so on
for all, so simply the answer is maximum digit in a string as, for maximum digit we need that many
1's else all it is us to requirement if we need 0 we can have 0 where ever reqired.
*/
class Solution {
    public int minPartitions(String n) {
        char max = '0';
        for(char ch : n.toCharArray()){
            max = (char)Math.max(max, ch);
            if(max == 57) return 9;
        }
        return max - '0';
    }
}