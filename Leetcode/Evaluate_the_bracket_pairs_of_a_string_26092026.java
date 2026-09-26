package Leetcode;

// leetcode - 1807
// tc - O(n), sc - O(m)
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String, String> mp = new HashMap<>();

        for(List<String> list : knowledge) {
            mp.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                i++;
                StringBuilder key = new StringBuilder();
                while(s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }
                String find = key.toString();
                if(mp.containsKey(find)) sb.append(mp.get(find));
                else sb.append('?');
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}