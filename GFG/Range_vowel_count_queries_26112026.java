package GFG;

// tc - O(n), sc - O(n)
class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int[] prefixSum = new int[n];
        ArrayList<Integer> result = new ArrayList<>();

        prefixSum[0] = isVowel(s.charAt(0)) ? 1 : 0;

        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1];

            if(isVowel(s.charAt(i))) prefixSum[i]++;
        }

        // System.out.println(Arrays.toString(prefixSum));

        for(int j = 0; j < m; j++) {
            int[] query = queries[j];
            int curr = prefixSum[query[1]];

            if(query[0] != 0) curr -= prefixSum[query[0] - 1];

            result.add(curr);
        }
        return result;
    }
}