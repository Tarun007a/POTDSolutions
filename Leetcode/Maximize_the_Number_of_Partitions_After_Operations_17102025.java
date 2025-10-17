package Leetcode;

// leetcode - 3003
// class Solution {
//     private int getCount(String s, int k, int i, char ch){
//         int n = s.length();
//         int count = 0;

//         int idx = 0;
//         while(idx < n){
//             count++;
//             HashSet<Character> set = new HashSet<>();
//             while(idx < n){
//                 if(idx == i) set.add(ch);
//                 else set.add(s.charAt(idx));
//                 if(set.size() > k) break;
//                 idx++;
//             }
//         }
//         return count;
//     }
//     public int maxPartitionsAfterOperations(String s, int k) {
//         int n = s.length();
//         int max = 0;
//         for(int i = 0; i < n; i++){
//             for(int ch = 0; ch < 26; ch++){
//                 max = Math.max(max, getCount(s, k, i, (char)(ch+'a')));
//             }
//         }
//         return max;
//     }
// }

// copied from editorial -> have to understand this
// tc - O(n*m) where m is max 26, sc - O(n)
public class Solution {

    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];

        int curr = 0;
        int mask = 0;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int binary = 1 << (s.charAt(i) - 'a');
            if ((mask & binary) == 0) {
                result++;
                if (result <= k) {
                    mask |= binary;
                } else {
                    curr++;
                    mask = binary;
                    result = 1;
                }
            }
            left[i + 1][0] = curr;
            left[i + 1][1] = mask;
            left[i + 1][2] = result;
        }

        curr = 0;
        mask = 0;
        result = 0;
        for (int i = n - 1; i > 0; i--) {
            int binary = 1 << (s.charAt(i) - 'a');
            if ((mask & binary) == 0) {
                result++;
                if (result <= k) {
                    mask |= binary;
                } else {
                    curr++;
                    mask = binary;
                    result = 1;
                }
            }
            right[i - 1][0] = curr;
            right[i - 1][1] = mask;
            right[i - 1][2] = result;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int seg = left[i][0] + right[i][0] + 2;
            int totMask = left[i][1] | right[i][1];
            int totCount = Integer.bitCount(totMask);
            if (left[i][2] == k && right[i][2] == k && totCount < 26) {
                seg++;
            } else if (Math.min(totCount + 1, 26) <= k) {
                seg--;
            }
            max = Math.max(max, seg);
        }
        return max;
    }
}