package Leetcode;

// leetcode - 3783
// tc - O(logn), sc - O(1)
class Solution {
    public int mirrorDistance(int n) {
        int m = n;
        int reverse = 0;
        while(m != 0){
            reverse = reverse * 10 + m%10;
            m /= 10;
        }
        return Math.abs(reverse - n);
    }
}
