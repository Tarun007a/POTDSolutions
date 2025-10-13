package Leetcode;

// Leetcode - 2273
// tc - O(n*k) where k is len of string
// sc - O(n) -> can be further optimised
class Solution {
    private int[] getCharArray(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray()) freq[ch-'a']++;
        return freq;
    }

    private boolean areAnagrams(int[] word1, int[] word2){
        for(int i = 0; i < 26; i++){
            if(word1[i] != word2[i]) return false;
        }
        return true;
    }

    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        int[] prev = getCharArray(words[0]);
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for(int i = 1; i < n; i++){
            int[] curr = getCharArray(words[i]);
            if(!areAnagrams(prev, curr)){
                prev = curr;
                result.add(words[i]);
            }
        }
        return result;
    }
}