package GFG;

// tc - O(nlogn + n * (n * n)
class Solution {
    static int catalan(int n) {
        if(n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        int[] sorted = new int[n];
        HashMap<Integer, Integer> sortedIdx = new HashMap<>();

        for(int i = 0; i < n; i++) sorted[i] = arr[i];

        Arrays.sort(sorted);
        for(int i = 0; i < n; i++) sortedIdx.put(sorted[i], i);

        ArrayList<Integer> result = new ArrayList<>();

        for(int i : arr){
            int pos = sortedIdx.get(i);
            int left = pos;
            int right = n - pos - 1;
            result.add(catalan(left) * catalan(right));
        }
        return result;
    }
}