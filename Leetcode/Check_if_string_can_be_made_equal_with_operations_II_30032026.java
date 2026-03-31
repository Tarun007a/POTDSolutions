package Leetcode;

// leetcode - 2840
// tc & sc - O(n+m)
class Solution {
    public boolean checkStrings(String s1, String s2) {
        HashMap<Character, Integer> evenRequired = new HashMap<>();
        HashMap<Character, Integer> oddRequired = new HashMap<>();

        boolean isEven = true;
        for(char ch : s1.toCharArray()) {
            if(isEven) evenRequired.put(ch, evenRequired.getOrDefault(ch, 0)+1);
            else oddRequired.put(ch, oddRequired.getOrDefault(ch, 0)+1);
            isEven = !isEven;
        }

        isEven  = true;
        for(char ch : s2.toCharArray()) {
            if(isEven) evenRequired.put(ch, evenRequired.getOrDefault(ch, 0)-1);
            else oddRequired.put(ch, oddRequired.getOrDefault(ch, 0)-1);
            isEven = !isEven;

            if(evenRequired.getOrDefault(ch, 0) == -1
                    || oddRequired.getOrDefault(ch, 0) == -1) return false;
        }
        return true;
    }
}
