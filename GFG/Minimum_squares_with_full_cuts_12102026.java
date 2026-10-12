package GFG;

// tc - O(log(min(n , m))), sc -O(1)
class Solution {
    public int minSquares(int n, int m) {
        int result = 0;
        while(n != 0 && m != 0) {
            if(n > m) {
                result += n / m;
                n = n % m;
            }
            else if(m > n) {
                result += m / n;
                m = m % n;
            }
            else {
                result++;
                break;
            }
        }
        return result;
    }
}