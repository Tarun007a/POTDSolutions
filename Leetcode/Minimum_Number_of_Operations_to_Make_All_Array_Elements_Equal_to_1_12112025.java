package Leetcode;

// leetcode - 2654
// tc - O(n*n*logm)
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int g = 0;
        for (int x : nums) {
            if (x == 1) {
                num1++;
            }
            g = gcd(g, x);
        }
        if (num1 > 0) {     // if one is present then it is done
            return n - num1;
        }
        if (g > 1) {         // if gcd of all element is greater than 1 then -1
            return -1;
        }

        int minLen = n;
        for (int i = 0; i < n; i++) {   // using brute force try to find a subarray with gcd -1
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}