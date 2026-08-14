package Leetcode;

// leetcode - 3090
// tc - O(n), sc - O(1)
class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] arr = new int[26];
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < n){
            char ch = s.charAt(j);
            int idx = (int)(ch-'a');
            arr[idx]++;
            j++;
            if(arr[idx] <= 2){
                ans = Math.max(ans,j-i);
            }
            else{
                while(arr[idx] > 2){
                    char c = s.charAt(i);
                    int id = (int)(c-'a');
                    arr[id]--;
                    i++;
                }
            }
        }
        return ans;
    }
}