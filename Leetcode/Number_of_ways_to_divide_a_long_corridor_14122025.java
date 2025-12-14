package Leetcode;

// leetcode - 2147
// tc - O(n), sc - O(1)
class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        long result = 1;
        long mod = (int)1e9 + 7;
        int totalSeats = 0;
        int seats = 0;
        int prevWays = 1;
        int i = 0;

        while(i < n){
            if(seats == 2){
                result *= (long)prevWays;
                result %= mod;

                int currWays = 1;
                while(i < n && corridor.charAt(i) == 'P'){
                    i++;
                    currWays++;
                }

                prevWays = currWays;
                seats = 0;
                continue;
            }
            else if(corridor.charAt(i) == 'S') {
                seats++;
                totalSeats++;
            }
            i++;
        }

        if(seats == 2) {
            result *= prevWays;
            result %= mod;
        }

        if((totalSeats&1) == 1 || totalSeats == 0) return 0;
        return (int)result;
    }
}
