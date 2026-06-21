// tc - O(n), sc - o(1)
class Solution {
    public String chooseSwap(String s) {
        int n = s.length();
        char curr = 'z';

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> swap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(char ch : s.toCharArray()) {
            curr = (char)Math.min(curr, ch);
            set.add(ch);
        }

        for(char ch : s.toCharArray()) {
            if(swap.containsKey(ch)) {
                sb.append(swap.get(ch));
            }

            else if(swap.size() != 0) {
                sb.append(ch);
            }

            else {
                if(ch < curr) {
                    sb.append(ch);
                }
                else if(ch == curr) {
                    sb.append(curr);
                    curr++;
                    while(!set.contains(curr) && curr < 'z') curr++;
                }
                else {
                    swap.put(ch, curr);
                    swap.put(curr, ch);
                    sb.append(curr);
                }
            }
        }
        return sb.toString();
    }
}