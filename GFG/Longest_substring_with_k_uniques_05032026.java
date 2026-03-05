package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int result = -1;
        int i = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int j = 0; j < n; j++) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);

            while(mp.size() > k) {
                char toRemove = s.charAt(i++);
                mp.put(toRemove, mp.get(toRemove)-1);
                if(mp.get(toRemove) == 0) mp.remove(toRemove);
            }
            if(mp.size() == k) result = Math.max(result, j-i+1);
        }
        return result;
    }
}
