package Leetcode;

// leetcode - 1390
// tc - O(n * sqrt(ele)) sc - O(1)
class Solution {
    private int getSum(int num){
        double sqrtInDouble = Math.sqrt(num);
        int sqrt = (int)sqrtInDouble;
        int sum = 0;
        int divisors = 0;

        for(int i = 1; i <= sqrt; i++){
            if(num%i == 0){
                divisors += 2;
                sum += i + num/i;
            }
        }

        if(sqrtInDouble == (double)sqrt){
            divisors--;
            sum -= sqrt;
        }
        return divisors == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for(int num : nums){
            result += getSum(num);
        }
        return result;
    }
}