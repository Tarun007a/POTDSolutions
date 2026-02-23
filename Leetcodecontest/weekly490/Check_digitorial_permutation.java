package Leetcodecontest.weekly490;

// leetcode - 3848
class Solution {
    private long getFact(int n){
        long fact = 1;
        while(n > 0){
            fact = fact * (long)n--;
        }
        return fact;
    }
    public boolean isDigitorialPermutation(int n) {
        int temp = n;
        long sum = 0;

        while(temp != 0){
            int digit = temp%10;
            temp /= 10;
            sum += getFact(digit);
        }

        String str1 = String.valueOf(sum);
        String str2 = String.valueOf(n);

        int[] freq = new int[10];
        for(char ch : str1.toCharArray()) freq[ch-'0']++;

        for(char ch : str2.toCharArray()) {
            freq[ch-'0']--;
            if(freq[ch-'0'] < 0) return false;
        }
        for(int i : freq){
            if(i != 0) return false;
        }
        return true;
    }
}
