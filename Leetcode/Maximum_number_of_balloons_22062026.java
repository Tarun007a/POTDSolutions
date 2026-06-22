// leetcode - 1189
// tc - O(n), sc - O(1)
class Solution {
    public int maxNumberOfBalloons(String text) {
        int min = 10000;
        HashMap<Character, Integer> mp = new HashMap<>();

        mp.put('b', 0);
        mp.put('a', 0);
        mp.put('l', 0);
        mp.put('o', 0);
        mp.put('n', 0);

        for(char ch : text.toCharArray()) {
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                mp.put(ch, mp.getOrDefault(ch, 0)+1);
            }
        }

        mp.put('l', mp.get('l')/2);
        mp.put('o', mp.get('o')/2);

        for(char key : mp.keySet()) {
            min = Math.min(min, mp.get(key));
        }
        return min;
    }
}