package GFG;

// tc - O(n*m*log(m)), sc - O(n*m)
class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int result = 0;

        int[][] ones = new int[n][m];

        for(int j = 0; j < m; j++) {
            ones[n-1][j] = mat[n-1][j];

            for(int i = n-2; i >= 0; i--) {
                if(mat[i][j] == 0) ones[i][j] = 0;
                else ones[i][j] = ones[i+1][j] + 1;
            }
        }

        for(int i = 0; i < n; i++) {
            int curr = 0;
            TreeMap<Integer, Integer> mp = new TreeMap<>((a, b) -> b - a);
            for(int j = 0; j < m; j++) {
                mp.put(ones[i][j], mp.getOrDefault(ones[i][j], 0) + 1);
            }

            for(int key : mp.keySet()) {
                curr += mp.get(key);
                result = Math.max(result, curr * key);
            }
        }
        return result;
    }
}