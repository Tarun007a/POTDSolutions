package Leetcode;

// leetcode 166
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString();

        result.append(".");

        Map<Long, Integer> mp = new HashMap<>();
        while (remainder != 0) {
            if (mp.containsKey(remainder)) {
                int index = mp.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            mp.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}