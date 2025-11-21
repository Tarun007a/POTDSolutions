package Leetcode;

// leetcode - 1930
// tc - O(n), sc - O(C) -> O(1){c is constant}
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int ans = 0;
        int[] min = new int[26];
        int[] max = new int[26];
        for(int i = 0; i < 26; i++){
            min[i]=Integer.MAX_VALUE;
            max[i]=Integer.MIN_VALUE;
        }
        for(int i = 0 ; i < n ; i++){
            int idx = (int)(s.charAt(i))-97;//ascii of a = 97
            min[idx]=Math.min(min[idx],i);
            max[idx]=Math.max(max[idx],i);
        }
        for(int i = 0; i < 26; i++){
            if(max[i]==Integer.MIN_VALUE || min[i]==Integer.MAX_VALUE) continue;
            HashSet<Character> hs = new HashSet<>();
            for(int j = min[i]+1; j < max[i]; j++){
                hs.add(s.charAt(j));
            }
            ans+=hs.size();
        }
        return ans;
    }
}