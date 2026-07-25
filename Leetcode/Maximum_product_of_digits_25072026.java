package Leetcode;

// leetcode - 3536
// tc - O(logn), sc - O(1)
class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;

        while(n != 0){
            int curr = n%10;
            n /= 10;

            if(curr > max1) {
                max2 = max1;
                max1 = curr;
            }
            else if(curr > max2) max2 = curr;
        }
        return max1 * max2;
    }
}