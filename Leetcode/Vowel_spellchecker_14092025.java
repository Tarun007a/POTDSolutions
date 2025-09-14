package Leetcode;

//leetcode 966
// This the first solution by me time complexity at worst - O(n * m * k) check is similar for all
// best - O(n) as hashset and linked hashmap answers in o(1)
 class Solution {
     private boolean isVowel(char ch){
         ch = Character.toLowerCase(ch);
         return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
     }

     private boolean isSimilar(String s1, String s2){
         int n = s1.length();
         for(int i = 0; i < n; i++){
             char c1 = s1.charAt(i);
             char c2 = s2.charAt(i);

             if(Character.toLowerCase(c1) == Character.toLowerCase(c2)) continue;
             else if(isVowel(c1) && isVowel(c2)) continue;
             return false;
         }
         return true;
     }

     private String vowelReplace(String str, String[] wordlist){
         int n = str.length();
         for(String check : wordlist){
             if(check.length() == n){
                 if(isSimilar(str, check)) return check;
             }
         }
         return "";
     }

     public String[] spellchecker(String[] wordlist, String[] queries) {
         int n = queries.length;

         String[] result = new String[n];

         HashSet<String> set = new HashSet<>();
         HashMap<String, String> mp = new LinkedHashMap<>();

         for(String str : wordlist){
             String lower = str.toLowerCase();;
             if(!mp.containsKey(lower)) mp.put(lower, str);
             set.add(str);
         }

         for(int i = 0; i < n; i++){
             String str = queries[i];
             String lower = str.toLowerCase();

             if(set.contains(str)) result[i] = str;
             else if(mp.containsKey(lower)) result[i] = mp.get(lower);
             else result[i] = vowelReplace(str, wordlist);
         }
         return result;
     }
 }

// O(n+m)
// as they want first word for case insensitivity normal mmp will work as if any word comes
// again then we will simply igonre and for vowel we will put there a * and then match
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] result = new String[n];
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> wordLowerCase = new HashMap<>();
        HashMap<String, String> vowelReplace = new HashMap<>();

        for(String word : wordlist){
            String lower = word.toLowerCase();
            set.add(word);
            if(!wordLowerCase.containsKey(lower)) wordLowerCase.put(lower, word);
            StringBuilder sb = new StringBuilder();

            for(char ch : lower.toCharArray()){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') sb.append('*');
                else sb.append(ch);
            }
            String newString = sb.toString();
            if(!vowelReplace.containsKey(newString)) vowelReplace.put(newString, word);
        }

        for(int i = 0; i < n; i++){
            String str = queries[i];
            String lower = str.toLowerCase();
            if(set.contains(str)) result[i] = str;
            else if(wordLowerCase.containsKey(lower)) result[i] = wordLowerCase.get(lower);
            else{
                StringBuilder sb = new StringBuilder();

                for(char ch : lower.toCharArray()){
                    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') sb.append('*');
                    else sb.append(ch);
                }
                String newString = sb.toString();
                if(vowelReplace.containsKey(newString)) result[i] = vowelReplace.get(newString);
                else result[i] = "";
            }
        }
        return result;
    }
}