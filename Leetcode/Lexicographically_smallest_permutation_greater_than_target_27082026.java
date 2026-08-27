package Leetcode;

// leetcode - 3720
// tc - O(n*n), sc - O(n)
class Solution {
    private char hasGreater(char c, HashMap<Character, Integer> mp) {
        for(int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            if(ch > c && mp.containsKey(ch)) return ch;
        }
        return '0';
    }

    private void addAll(StringBuilder sb, HashMap<Character, Integer> mp) {
        for(int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            if(mp.containsKey(ch)) {
                for(int j = 0; j < mp.get(ch); j++) sb.append(ch);
            }
        }
    }

    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        int i = 0;
        for(; i < n; i++) {
            char ch = target.charAt(i);

            if(mp.containsKey(ch)) {
                sb.append(ch);
                mp.put(ch, mp.get(ch)-1);
                if(mp.get(ch) == 0) mp.remove(ch);
            }
            else break;
        }

        if(i < n && hasGreater(target.charAt(i), mp) != '0') {
            char ch = hasGreater(target.charAt(i), mp);
            sb.append(ch);

            mp.put(ch, mp.get(ch)-1);
            if(mp.get(ch) == 0) mp.remove(ch);
            addAll(sb, mp);
        }
        else {
            i--;
            while(i >= 0) {
                char ch = sb.charAt(i);
                // delete take O(n) and so n^2 is tc, as we know the size of resultand str we can use arr and then tc - O(n)
                sb.deleteCharAt(i);
                mp.put(ch, mp.getOrDefault(ch, 0)+1);
                char newCh = hasGreater(target.charAt(i), mp);

                if(newCh == '0') i--;
                else {
                    sb.append(newCh);
                    mp.put(newCh, mp.get(newCh)-1);
                    addAll(sb, mp);
                    break;
                }
            }
        }

        return sb.toString();
    }
}