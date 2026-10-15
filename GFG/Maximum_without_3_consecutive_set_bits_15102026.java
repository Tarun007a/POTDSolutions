package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int maxValue(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();

        int curr = 0;
        for(char ch : str.toCharArray()) {
            if(ch == '1') curr++;
            if(curr == 3 || ch == '0') {
                curr = 0;
                sb.append('0');
            }
            else sb.append('1');
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}