package Leetcode;

// leetcode - 3867
// tc - n*log(min(a, b)) + n*log(n) + n*log(min(a, b)), sc - O(n)
class Solution {
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        long result = 0;

        int mx = nums[0];
        int[] prefixGcd = new int[n];

        for(int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefixGcd);
        int i = 0;
        int j = n-1;

        while(i < j) {
            result += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return result;
    }
}