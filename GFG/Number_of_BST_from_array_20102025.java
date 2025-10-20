package GFG;

class Solution {
    private static int[] dp;

    static void catalan(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
    }

    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        dp = new int[n+1];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> sortedIdx = new HashMap<>();

        for(int i = 0; i < n; i++) sorted[i] = arr[i];

        Arrays.sort(sorted);
        for(int i = 0; i < n; i++) sortedIdx.put(sorted[i], i);

        ArrayList<Integer> result = new ArrayList<>();

        catalan(n);

        for(int i : arr){
            int pos = sortedIdx.get(i);
            int left = pos;
            int right = n - pos - 1;
            result.add(dp[left] * dp[right]);
        }
        return result;
