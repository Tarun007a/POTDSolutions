package Leetcodecontest.weekly517;

class Solution {
    long mod = 1000000007;

    private long calcPow(long first, long second) {
        if(second == 0) return 1;
        if(second == 1) return first;

        long curr = calcPow(first, second / 2);

        return ((curr * curr) % mod * (second%2 == 1 ? first : 1)) % mod;
    }

    private long getValue(long num) {
        long w = num % 10;
        long d = num / 10l;

        String s = "" + d;
        long first = 0;
        long second = 0;

        for(int i = 0; i < s.length(); i++) {
            long curr = (long)(s.charAt(i) - '0');
            if(i < w) first = first * 10 + curr;
            else second = second * 10 + curr;
        }

        // System.out.println(d + " " + first + " " + second);

        return calcPow(first, second);
    }

    public int sumDecoded(long[] nums) {
        long result = 0;

        for(long num : nums) {
            result += getValue(num);
            result %= mod;
        }
        return (int)result;
    }
}