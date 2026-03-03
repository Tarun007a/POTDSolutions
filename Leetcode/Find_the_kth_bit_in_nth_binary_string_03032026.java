package Leetcode;

//similar to 779 , 3307 do them
// If question says this to that then once think of opposite that to this.
//TC - O(n) and space = O(n)
//We can convert the recursive approach to an iterative one to avoid the excess
//stack space taken by the recursion then space is O(1) -> see tutorial
class Solution {
    public char findKthBit(int n, int k) {
        // Base case: When n = 1, the binary string is "0"
        if (n == 1) return '0';

        // Find the length of the current string Sn, which is 2^n - 1
        int size = (1 << n) - 1;

        // Find the middle position
        int mid = size / 2 + 1;

        // If k is the middle position, return '1'
        if (k == mid) return '1';

        // If k is in the first half, find the bit in Sn-1
        if (k < mid) return findKthBit(n - 1, k);

        // If k is in the second half, find the bit in Sn-1 and invert it
        //as the second half is reverse and inverted so the kth bit after reverse will be at
        //size-(k-1) -> size-k+1 so in first half find it and reverse
        return findKthBit(n - 1, size - k + 1) == '0' ? '1' : '0';
    }
}

//Brute force tc - 2^n
// class Solution {
//     StringBuilder[] arr = new StringBuilder[21];
//     private void rec(int i){
//         if(arr[i] != null)return;
//         rec(i-1);
//         arr[i] = new StringBuilder(arr[i-1]+"1"+reverseAndInvert(arr[i-1]));
//     }
//     private StringBuilder reverseAndInvert(StringBuilder sb1){
//         StringBuilder sb = new StringBuilder(sb1);
//         int n = sb.length();
//         int i = 0;
//         int j = n-1;

//         while(i <= j){
//             if(i == j){
//                 sb.setCharAt(i, sb.charAt(i) == '1' ? '0' : '1');
//                 break;
//             }
//             char t = sb.charAt(i);
//             sb.setCharAt(i,sb.charAt(j) == '1' ? '0' : '1');
//             sb.setCharAt(j, t == '1' ? '0' : '1');
//             i++;
//             j--;
//         }
//         //System.out.println(sb2+" "+sb.toString());
//         return sb;
//     }
//     public char findKthBit(int n, int k) {
//         if(n == 1)return '0';
//         arr[1] = new StringBuilder("0");
//         rec(n);
//         //System.out.print(sb);
//         return arr[n].charAt(k-1);
//     }
// }

//Brute force tc - 2^n
// class Solution {
//     private StringBuilder reverseAndInvert(StringBuilder sb1){
//         StringBuilder sb = new StringBuilder(sb1);
//         int n = sb.length();
//         int i = 0;
//         int j = n-1;

//         while(i <= j){
//             if(i == j){
//                 sb.setCharAt(i, sb.charAt(i) == '1' ? '0' : '1');
//                 break;
//             }
//             char t = sb.charAt(i);
//             sb.setCharAt(i,sb.charAt(j) == '1' ? '0' : '1');
//             sb.setCharAt(j, t == '1' ? '0' : '1');
//             i++;
//             j--;
//         }
//         //System.out.println(sb2+" "+sb.toString());
//         return sb;
//     }
//     public char findKthBit(int n, int k) {
//         if(n == 1)return '0';
//         StringBuilder sb = new StringBuilder("0");
//         for(int i = 2; i <= n; i++){
//             //System.out.println(sb);
//             sb.append("1"+reverseAndInvert(sb));
//             //System.out.println(sb);
//         }
//         //System.out.print(sb);
//         return sb.charAt(k-1);
//     }
// }