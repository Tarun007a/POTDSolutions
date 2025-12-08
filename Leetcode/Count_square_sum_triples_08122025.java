package Leetcode;

// leetcode 1925
// tc - O(n*n), sc - O(1)
class Solution {
    public int countTriples(int n) {
        int count = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int sq = i*i + j*j;
                int num = (int)Math.sqrt(sq);
                if(num <= n && num*num == sq) count++;
            }
        }
        return count;
    }
}