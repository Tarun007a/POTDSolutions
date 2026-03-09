package Leetcode;

// leetcode - 3129
// tc - O(zero * one * limit), sc - O(zero * one * limit)
class Solution {
    public int rec(int one, int zero, int limit, int prev, int same, int[][][][] dp, int mod){
        if(same > limit)return 0;
        if(one == 0 && zero == 0)return 1;

        if(dp[one][zero][prev][same] != -1)return dp[one][zero][prev][same];

        int putOne = 0;
        int putZero = 0;

        if(one != 0){
            if(prev == 2 || prev == 0) putOne = rec(one-1, zero, limit, 1, 1, dp, mod);
            else putOne = rec(one-1, zero, limit, 1, same+1, dp, mod);
        }
        if(zero != 0){
            if(prev == 2 || prev == 1)putZero = rec(one, zero-1, limit, 0, 1, dp, mod);
            else putZero = rec(one, zero-1, limit, 0, same+1, dp, mod);
        }

        return dp[one][zero][prev][same] = (putOne+putZero)%mod;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][][] dp = new int[one+1][zero+1][3][limit+1];
        for(int i = 0; i <= one; i++){
            for(int j = 0; j <= zero; j++){
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l <= limit; l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return rec(one, zero, limit, 2, 0, dp, 1000000007);

    }
}
