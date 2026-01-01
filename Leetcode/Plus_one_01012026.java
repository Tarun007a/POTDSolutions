package Leetcode;

// leetcode - 66
// tc - O(n), sc - O()
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;

        for(int i = n-1; i >= 0; i--){
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if(carry == 0) return digits;

        int[] result = new int[n+1];
        result[0] = carry;

        for(int i = 1; i < n+1; i++){
            result[i] = digits[i-1];
        }
        return result;
    }
}
