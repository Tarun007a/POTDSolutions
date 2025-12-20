package Leetcode;

// leetcode - 944
// tc - O(n*m), sc - O(1)
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int result = 0;

        for(int i = 0; i < n; i++){
            char prev = 'A';
            for(String str : strs){
                if(prev > str.charAt(i)) {
                    result++;
                    break;
                }
                prev = str.charAt(i);
            }
        }
        return result;
    }
}
