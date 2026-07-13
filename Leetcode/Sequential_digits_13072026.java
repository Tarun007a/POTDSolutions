package Leetcode;

// leetcode - 1291
// class Solution {
//     private StringBuilder getString(int n) {
//         StringBuilder sb = new StringBuilder();

//         for(int i = 1; i <= n; i++) sb.append(i);

//         // System.out.println(sb);
//         return sb;
//     }

//     private StringBuilder inc(StringBuilder sb) {
//         int n = sb.length();
//         if(sb.charAt(n-1) == '9') {
//             return getString(n+1);
//         }

//         for(int i = 0; i < n; i++) {
//             char ch = sb.charAt(i);
//             char newCh = (char)(ch + 1);
//             sb.setCharAt(i, newCh);
//         }
//         return sb;
//     }

//     public List<Integer> sequentialDigits(int low, int high) {
//         int size = String.valueOf(low).length();
//         List<Integer> result = new ArrayList<>();
//         StringBuilder sb = getString(size);

//         while(true) {
//             if(sb.length() == 11) break;
//             int num = Integer.parseInt(sb.toString());
//             if(num > high) break;

//             // System.out.println(sb);
//             if(num >= low) result.add(num);
//             sb = inc(sb);
//         }

//         return result;
//     }
// }


// in the range 10 to 10^9 there are only the given sequential digits
// 12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,123456,234567,345678,456789,1234567,2345678,3456789,12345678,23456789,123456789
// so we can say tc & sc - O(1)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 9; i++){
            int n = i;
            int nextNum = n+1;
            while(n <= high && nextNum <= 10){
                if(n >= low)ans.add(n);
                n = (n*10)+nextNum;
                nextNum++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}







