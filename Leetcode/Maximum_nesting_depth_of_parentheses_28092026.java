package Leetcode;

// leetcode - 1614
// tc - O(n), sc - O(1)
class Solution {
    public int maxDepth(String s) {
        int size = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == ')')size--;
            else if(ch == '('){
                size++;
                ans = Math.max(ans,size);
            }
        }
        return ans;
    }
}
