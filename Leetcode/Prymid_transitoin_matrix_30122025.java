package Leetcode;

// leetcode - 756
class Solution {
    private boolean isPossible(int idx, String bottom, StringBuilder sb, HashMap<String, List<Character>> mp){
        int n = bottom.length();
        if(n == 1) return true;
        if(idx == n-1){
            return isPossible(0, sb.toString(), new StringBuilder(), mp);
        }

        String str = "" + bottom.charAt(idx) + bottom.charAt(idx+1);

        for(char ch : mp.getOrDefault(str, new ArrayList<>())){
            if(isPossible(idx+1, bottom, sb.append(ch), mp)) return true;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int n = bottom.length();
        HashMap<String, List<Character>> mp = new HashMap<>();

        for(String s : allowed){
            String key = s.substring(0, 2);
            if(!mp.containsKey(key)) mp.put(key, new ArrayList<>());
            mp.get(key).add(s.charAt(2));
        }
        return isPossible(0, bottom, new StringBuilder(), mp);
    }
}