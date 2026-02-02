package Leetcodecontest.weekly487;

class Solution {
    private boolean isMonobit(int n){
        int bit = n&1;

        while(n != 0){
            if((n&1) != bit) return false;
            n = n>>1;
        }
        return true;
    }
    public int countMonobit(int n) {
        int result = 0;
        for(int i = 0; i <= n; i++){
            if(isMonobit(i)) result++;
        }
        return result;
    }
}