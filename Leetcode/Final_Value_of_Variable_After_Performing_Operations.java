package Leetcode;

// leetcode - 2011
// tc - O(n) space - O(1)
class Solution {
    public int finalValueAfterOperations(String[] arr) {
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            String s = arr[i];
            if(s.equals("++X") || s.equals("X++")) ans++;
            else ans--;
        }
        return ans;
    }
}