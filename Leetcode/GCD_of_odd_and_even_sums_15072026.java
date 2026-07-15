package Leetcode;

// leetcode - 3658
// tc - O(log(n^2)) ~ 2*O(log(n)) ~ O(log(n)), sc - O(1)
// using formula for even and odd
// class Solution {
//     public int gcdOfOddEvenSums(int n) {
//         int odd = n*n;
//         int even = n*(n+1);

//         while(even != 0) {
//             int temp = odd % even;
//             odd = even;
//             even = temp;
//         }
//         return odd;
//     }
// }


// now look at the formula
// odd -> n*n and even -> n*(n+1)  here gcd is already common whcih is n
// so simply return n
// tc & sv - O(1)
class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}
