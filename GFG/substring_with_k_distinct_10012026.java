package GFG;

// tc - O(n), sc - O(1)
class Solution {
    private int getAtmostK(String s, int k){
        int n = s.length();
        int result = 0;
        int prev = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while(mp.size() > k) {
                char toRemove = s.charAt(prev++);
                mp.put(toRemove, mp.get(toRemove) - 1);
                if(mp.get(toRemove) == 0) mp.remove(toRemove);
            }
            result += i-prev+1;
        }
        return result;
    }

    public int countSubstr(String s, int k) {
        int n = s.length();
        return getAtmostK(s, k) - getAtmostK(s, k-1);
    }
}