package Leetcode;

// leetcode - 2243
// tc - O(n), sc - O(n)
class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > k) {
            int i = 0;
            int size = sb.length();
            StringBuilder curr = new StringBuilder();
            int rounds = size/k + (size%k == 0 ? 0 : 1);

            for(int j = 0; j < rounds; j++) {
                int count = 0;
                int sum = 0;

                while(count < k && i < size) {
                    sum += sb.charAt(i++) - '0';
                    count++;
                }

                curr.append(sum);
            }
            sb = curr;
        }

        return sb.toString();
    }
}