package Leetcode;

// leetcode - 3583
// tc - O(n), sc - O(n)
class Solution {
    public int specialTriplets(int[] nums) {
        long result = 0;
        long mod = (long)(1e9+7);
        int max = Arrays.stream(nums).max().getAsInt();

        int[] left = new int[max+1];
        int[] right = new int[max+1];

        for(int i : nums) right[i]++;

        for(int i : nums){
            right[i]--;
            int req = i * 2;

            if(req <= (long)max){
                long leftOcc = (long)left[req];
                long rightOcc = (long)right[req];

                result += leftOcc * rightOcc;
                result %= mod;
            }
            left[i]++;
        }
        return (int)result;
    }
}