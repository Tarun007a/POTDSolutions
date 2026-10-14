package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int[] operations = new int[n];

        for(int ope : roll) operations[ope-1]++;

        for(int i = n-2; i >= 0; i--) operations[i] += operations[i+1];

        for(int i = 0; i < n; i++) {
            int idx = (s.charAt(i) - 'a' + operations[i]) % 26;
            sb.append((char)('a' + idx));
        }
        return sb.toString();
    }
}
