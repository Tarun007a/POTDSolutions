package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int solve(int n, String s) {
        int num = 0;
        int rejected = 0;
        int result = 0;

        for(char ch : s.toCharArray()) {
            int idx = (ch-'A')+1;

            if((rejected & (1<<idx)) > 0){
                continue;
            }
            else if(((1<<idx) & num) == 0){
                if(n > 0) {
                    n--;
                    num = num | (1<<idx);
                }
                else {
                    rejected = rejected | (1<<idx);
                    result++;
                }
            }
            else {
                n++;
                num = (~(1<<idx)) & num;
            }
        }
        return result;
    }
}

