package Leetcode;

// leetcode - 1513
// tc - O(n), sc - O(1)
class Solution {
    public int numSub(String s) {
        int n = s.length();
        int result = 0;
        int count = 0;
        int mod = (int)1e9 + 7;

        for(int end = 0; end < n; end++){
            if(s.charAt(end) == '1'){
                count++;
                result += count;
                result %= mod;
            }
            else count = 0;
        }
        return result;
    }
}
