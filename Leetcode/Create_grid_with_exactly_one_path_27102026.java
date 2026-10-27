package Leetcode;

// leetcode - 3963
// tc - O(n + m + n), sc - O(n)
class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];

        StringBuilder sb = new StringBuilder();

        sb.append('.');
        for(int i = 0; i < n-1; i++) sb.append('#');
        String str = sb.toString();

        for(int i = 0; i < m-1; i++) {
            result[i] = str;
        }

        sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append('.');
        result[m-1] = sb.toString();

        return result;
    }
}