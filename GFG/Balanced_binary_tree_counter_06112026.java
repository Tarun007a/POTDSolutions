package GFG;

// Give StackOverFlow, even for h = 2, find out why?
// class Solution {
//     long mod = (long)(1e9) + 7;
//     long[] dp;

//     private long helper(int h) {
//         if(h <= 1) return 1;

//         if(dp[h] != -1) return dp[h];

//         long opt1 = helper(h-1);
//         long opt2 = helper(h-2);

//         return dp[h] = (((opt1 * opt2) % mod + (opt1 * opt1) % mod) % mod + (opt2 * opt1) % mod) % mod;
//     }

//     public int countBT(int h) {
//         dp = new long[h+1];
//         Arrays.fill(dp, -1);

//         return (int)helper(h);
//     }
// }




 tc - O(h), sc - O(1)
 class Solution {
     public int countBT(int h) {
         if(h <= 1) return 1;
         long mod = (long)(1e9) + 7;

         long prev = 1;
         long pp = 1;

         for(int i = 2; i <= h; i++) {
             long curr = ((2 * ((prev * pp) % mod)) % mod + (prev * prev) % mod) % mod;
             pp = prev;
             prev = curr;
         }

         return (int)prev;
     }
 }























