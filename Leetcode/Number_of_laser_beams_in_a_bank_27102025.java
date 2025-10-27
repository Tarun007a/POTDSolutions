package Leetcode;

// leetcode 2125
// tc - O(n*m), sc - O(1)
class Solution {
    private int getCount(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1') count++;
        }
        return count;
    }
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int result = 0;

        int prev = getCount(bank[0]);
        for(int i = 1; i < n; i++){
            int curr = getCount(bank[i]);

            if(curr == 0) continue;
            result += prev * curr;
            prev = curr;
        }
        return result;
    }
}