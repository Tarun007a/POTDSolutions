package Leetcode;

// leetcode - 2483
// tc - O(n), sc - O(1)
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] penaltyAhead = new int[n];
        int curr = 0;
        int idx = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            if(customers.charAt(i) == 'Y')curr++;
            else curr--;
            if(curr > max){
                curr = max;
                idx = i+1;
            }
        }
        return idx;
    }
}