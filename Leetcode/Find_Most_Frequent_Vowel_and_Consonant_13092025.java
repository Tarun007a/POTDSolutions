package Leetcode;

// Time - O(n) and Space - O(26) -> O(1)
public class Find_Most_Frequent_Vowel_and_Consonant_13092025 {
    public int maxFreqSum(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for(int i = 0; i < n; i++){
            freq[(int)(s.charAt(i)-'a')]++;
        }
        int vowel = 0;
        int cons = 0;

        for(int i = 0; i < 26; i++){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) vowel = Math.max(vowel, freq[i]);
            else cons = Math.max(cons, freq[i]);
        }
        return vowel + cons;
    }
}