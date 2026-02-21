package Leetcode;

// leetcode - 762
// tc - O((right - left) * logk)  sc - O(1)
// logk is log base 2 as we are counting bits in a number where for logk max iterations will be 32
// so it is ~ O(1) and overall tc - O(right -left)
class Solution {
    private static boolean[] isPrime;
    private static int size = 33;
    static {
        isPrime = new boolean[size];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i < size; i++){
            if(isPrime[i]){
                for(int j = i*i; j < size; j += i) isPrime[j] = false;
            }
        }
    }

    private int getBitCount(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;

        for(int num = left; num <= right; num++){
            int count = getBitCount(num);
            if(isPrime[count]) result++;
        }
        return result;
    }
}