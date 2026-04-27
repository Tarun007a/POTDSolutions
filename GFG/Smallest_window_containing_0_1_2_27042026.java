package GFG;

// tc - O(n), sc - o(1)
class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int zero = 0;
        int one = 0;
        int two = 0;
        int result = 1000000;
        int prev = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') zero++;
            else if(s.charAt(i) == '1') one++;
            else two++;

            while(zero > 0 && one > 0 && two > 0) {
                result = Math.min(result, i-prev+1);
                if(result == 3) return 3;

                if(s.charAt(prev) == '0') zero--;
                else if(s.charAt(prev) == '1') one--;
                else two--;
                prev++;
            }
        }
        return result == 1000000 ? -1 : result;
    }
};
