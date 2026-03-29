package Leetcode;

// leetcode - 2839
// tc & sc - O(1)

class Solution {
    public boolean canBeEqual(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        if(sb.charAt(0) != s2.charAt(0)) {
            if(sb.charAt(2) != s2.charAt(0)) return false;
            sb.setCharAt(2, sb.charAt(0));
            sb.setCharAt(0, s2.charAt(0));
        }

        if(sb.charAt(1) != s2.charAt(1)) {
            if(sb.charAt(3) != s2.charAt(1)) return false;
            sb.setCharAt(3, sb.charAt(1));
            sb.setCharAt(1, s2.charAt(1));
        }

        return s2.equals(sb.toString());
    }
}