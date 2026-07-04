package GFG;

class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        long result = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int curr = 0;
        int prev = 0;
        int smaller = 0;

        mp.put(0, 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') curr++;
            else curr--;

            if (curr > prev) {
                smaller += mp.getOrDefault(prev, 0);
            }
            else {
                smaller -= mp.getOrDefault(curr, 0);
            }

            result += smaller;
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
            prev = curr;
        }

        return (int) result;
    }
}
