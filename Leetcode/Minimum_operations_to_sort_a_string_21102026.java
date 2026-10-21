package Leetcode;

// leetcode - 3868
// tc - O(n), sc - O(1)
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        if(n == 1) return 0;

        char smallest = 'z';
        char largest = 'a';
        char prev = 'a';
        boolean isSorted = true;
        int freq1 = 0;
        int freq2 = 0;

        for(char ch : s.toCharArray()) {
            if(smallest > ch) {
                smallest = ch;
                freq1 = 1;
            }
            else if(smallest == ch) freq1++;

            if(largest < ch) {
                largest = ch;
                freq2 = 1;
            }
            else if(largest == ch) freq2++;

            if(ch < prev) isSorted = false;
            prev = ch;
        }

        if(isSorted) return 0;

        if(n == 2) return -1;

        if(s.charAt(0) == smallest || s.charAt(n-1) == largest) return 1;

        if(s.charAt(0) == largest && s.charAt(n-1) == smallest && freq1 == 1 && freq2 == 1) return 3;

        return 2;
    }
}