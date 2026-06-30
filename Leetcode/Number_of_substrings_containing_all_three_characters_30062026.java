package Leetcode;

// leetcode - 1358
// tc - O(n), sc - O(1)
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int result = 0;
        int st = 0;
        int idx = 0;
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a') cntA++;
            else if(ch == 'b') cntB++;
            else cntC++;

            while(cntA > 0 && cntB > 0 && cntC > 0) {
                char toRemove = s.charAt(idx);
                if(toRemove == 'a') {
                    if(cntA == 1) break;
                    else cntA--;
                }
                else if(toRemove == 'b') {
                    if(cntB == 1) break;
                    else cntB--;
                }
                else {
                    if(cntC == 1) break;
                    else cntC--;
                }
                idx++;
            }

            if(cntA > 0 && cntB > 0 && cntC > 0) {
                int left = idx - st + 1;
                int right = n - i;
                result += left * right;

                char remove = s.charAt(idx);
                if(remove == 'a') cntA--;
                else if(remove == 'b') cntB--;
                else cntC--;

                idx++;
                st = idx;
            }
        }
        return result;
    }
}
