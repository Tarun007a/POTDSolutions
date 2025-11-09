package Leetcode;

// Euclidean Algorithm
// leetcode - 2169
// tc - O(log(max(num1, num2))), sc - O(1)

// here this is very similar to euclidean algo to find gcd just one catch is that we do not
// need to guarantee that num1 >= num2 as if num1 < num2 num1/num2 will give 0 and then swap
// them so no problem
class Solution {
    public int countOperations(int num1, int num2) {
        int result = 0;

        while(num1 != 0 && num2 != 0){
            result += num1/num2;
            int mod = num1%num2;

            num1 = num2;
            num2 = mod;
        }
        return result;
    }
}
