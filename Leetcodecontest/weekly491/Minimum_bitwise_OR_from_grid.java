package Leetcodecontest.weekly491;

// Not able to do in contest
// leetcode - 3858
// we need min number and for or if we once set a bit then it will be always set so we will try to
// keep the msb as 0, as grid[i][j] <= 10^5 means we have 20 bits. Now we will try to keep the largest bit
// 0 it can be 0 if in each row there is atleast a number where the particular bit is 0. Now let we are
// on bit b and in each row there is a number with that bit 0 so we fixed that this bth bit can be set to
// 0 and fix fix it to 0 in our ansewr. Now when we move to the next msb (smaller then the previous one)
// we cannot take numbers where the previous bit is 1 as in prev iteration wewe fixed it to 0 and therefore
// we maintain a fixedZero number, where we keep the bit as 1 which we fixed to 0 and perform & with
// each if & is non zero means there is a bit which is 1 and we fixed it to 0 so we will not consider
// that number

class Solution {
    public int minimumOR(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fixedZero = 0;
        int result = 0;

        for(int bit = 20; bit >= 0; bit--) {
            int checkBit = 1 << bit;
            boolean canSetZeroForEachRow = true;
            for(int i = 0; i < n; i++) {
                boolean canSetToZero = false;
                for(int num : grid[i]) {
                    // fixedZero & num == 0 is to check that the bit which we fixed to zero are
                    // are also 0 here and if the bit can be 0 i.e. (checkBit & grid[i][j]) == 0
                    // means we can fix this bit also to zero for this row
                    if((fixedZero & num) == 0 && (checkBit & num) == 0) {
                        canSetToZero = true;
                        break;
                    }
                }
                if(!canSetToZero) {
                    canSetZeroForEachRow = false;
                    break;
                }
            }
            if(canSetZeroForEachRow) fixedZero = fixedZero | checkBit;  // set that this bit is fixed to 0
            else result = result | checkBit;
        }
        return result;
    }
}
