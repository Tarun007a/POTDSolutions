// leetcode 3614
// codestorywithmik
// Approach (Reverse Simulation)
// TC - O(n) 
// SC : O(1)
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long L = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (L > 0)
                    L--;
            } else if (ch == '#') {
                L *= 2;
            } else if (ch == '%') {
                // reverse - no change in L
                continue;
            } else { // 'a' to 'z'
                L++;
            }
        }

        if (k >= L) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                L++; // no change in k
            } else if (ch == '%') {
                // no change in L
                k = L - k - 1;
            } else if (ch == '#') {
                L = L / 2;
                k = (k >= L) ? k - L : k;
            } else { // 'a' to 'z'
                L--;
            }

            if (k == L) {
                return ch;
            }
        }

        return '.';
    }
}


// reverse simulation by me using recursion (learned from code story with mik)
// tc - O(n), sc - O(n)
class Solution {
    private char rec(int i, long k, long len, String s) {
        char ch = s.charAt(i);

        if(ch == '#') {
            len = len/2;
            if(k >= len) k -= len;
            return rec(i-1, k, len, s);
        }
        if(ch == '*') {
            return rec(i-1, k, len+1, s);
        }
        if(ch == '%') {
            return rec(i-1, len-k-1, len, s);
        }
        if(k+1 == len) return ch;
        return rec(i-1, k, len-1, s);
    }

    public char processStr(String s, long k) {
        int n = s.length();
        long len = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '*') len--;
            else if(ch == '#') len *= 2;
            else if(ch == '%') continue;
            else len++;
            if(len < 0) len = 0;
        }

        if(len <= k) return '.';
        return rec(n-1, k, len, s);
    }
}