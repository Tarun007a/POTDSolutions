package Leetcodecontest.weekly516;

class Solution {
    private boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length()-1;

        while(lo < hi) {
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }

    private String convertToBinary(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            if(n == 0) sb.append('0');
            else {
                if(n%2 == 1) sb.append('1');
                else sb.append('0');
                n = n/2;
            }
        }
        sb.reverse();
        System.out.println(sb);
        return sb.toString();
    }

    public boolean isPalindromic(String s) {
        String str = "";

        for(char ch : s.toCharArray()) {
            str += convertToBinary((int)ch);
            // System.out.println(str);
        }
        return isPalindrome(str);
    }
}