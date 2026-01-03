package Leetcode;

// leetcode - 1411
// tc - O(12 * n) × O(1) as works per statie is constant and 12 as at any level at max 12 strings can be there
// tc ~ O(n), sc - O(n) (similarly)
class Solution {
    HashMap<String, HashMap<Integer, Integer>> mp;
    static final int MOD = 1000000007;

    private void getAll(int idx, char prev, StringBuilder sb, String s, char[] choices, ArrayList<String> list){
        if(idx == 3){
            list.add(sb.toString());
            return;
        }

        for(char ch : choices){
            if(ch != prev && ch != s.charAt(idx)){
                sb.append(ch);
                getAll(idx+1, ch, sb, s, choices, list);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    private ArrayList<String> getNextString(String s){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] choices = {'R', 'Y', 'G'};

        getAll(0, 'd', sb, s, choices, list);
        return list;
    }

    private int helper(String s, int n){
        if(n == 0) return 1;
        int result = 0;

        if(mp.containsKey(s) && mp.get(s).containsKey(n)) return mp.get(s).get(n);

        for(String curr : getNextString(s)){
            result += helper(curr, n-1);
            result %= MOD;
        }

        if(!mp.containsKey(s)) mp.put(s, new HashMap<>());
        mp.get(s).put(n, result % MOD);
        return result % MOD;
    }

    public int numOfWays(int n) {
        String[] arr = {"RGR", "RGY", "RYR", "RYG", "YRY", "YRG", "YGR", "YGY", "GRG", "GRY", "GYG", "GYR"};
        int result = 0;
        mp = new HashMap<>();

        for(String s : arr){
            result += helper(s, n-1);
            result %= MOD;
        }
        return result;
    }
}