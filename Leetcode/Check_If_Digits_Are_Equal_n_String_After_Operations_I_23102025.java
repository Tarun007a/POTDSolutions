package Leetcode;

// leetcode - 3416
// tc - O(n^2), sc - O(n)
class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] arr = new int[n];

        int idx = 0;
        for(char ch : s.toCharArray()){
            arr[idx++] = ch-'0';
        }

        int len = n-1;
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < len; j++){
                arr[j] = (arr[j]+arr[j+1])%10;
            }
            len--;
        }
        return arr[0] == arr[1];
    }
}