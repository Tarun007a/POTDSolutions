package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxCharGap(String s) {
        int result = -1;
        int[] occuredIdx = new int[26];
        Arrays.fill(occuredIdx, -1);

        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i)-'a';

            if(occuredIdx[ch] == -1) occuredIdx[ch] = i;
            else result = Math.max(result, i - occuredIdx[ch] - 1);
        }
        return result;
    }
};