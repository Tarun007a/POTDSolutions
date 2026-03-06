package GFG;

// tc - O(n+m), sc - O(26) ~ O(1)
class Solution {
    private static int checkRatio(HashMap<Character, Integer> mp1, HashMap<Character, Integer> mp2) {
        for(char key : mp1.keySet()) {
            if(mp2.getOrDefault(key, 0) < mp1.get(key)) return -1;
        }
        return 0;
    }

    public static String minWindow(String s, String p) {
        int n = s.length();
        int min = n+1;
        int stIdx = -1;
        int st = 0;
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> curr = new HashMap<>();

        for(char ch : p.toCharArray()) {
            required.put(ch, required.getOrDefault(ch, 0)+1);
        }

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            curr.put(ch, curr.getOrDefault(ch, 0)+1);

            while(checkRatio(required, curr) == 0) {
                if(min > i-st+1) {
                    min = i-st+1;
                    stIdx = st;
                }
                char toRemove = s.charAt(st++);
                curr.put(toRemove, curr.get(toRemove)-1);
            }
        }
        if(stIdx == -1) return "";
        return s.substring(stIdx, stIdx+min);
    }
}
