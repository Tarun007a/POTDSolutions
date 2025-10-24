package Leetcode;

// leetcode - 2024
// tc - O(C - n) c = 1224444 largest possible number
class Solution {
    private boolean isBalanced(int num){
        int[] freq = new int[10];
        while(num != 0){
            int digit = num%10;
            freq[digit]++;
            num /= 10;
        }
        for(int i = 0; i < 10; i++){
            if(freq[i] != 0 && freq[i] != i) return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int curr = n+1;
        while(true){
            if(isBalanced(curr)) return curr;
            curr++;
        }
    }
}