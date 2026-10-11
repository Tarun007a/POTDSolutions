package Leetcodecontest.weekly523;

// done after contest end (6 min later) at 9:36
class Solution {
    List<Integer>[][] dp;

    private List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i*i < n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j < n; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i < n; i++) {
            if(isPrime[i]) list.add(i);
        }
        return list;
    }

    private List<Integer> helper(int i, int currSum, List<Integer> primes) {
        if(i == primes.size() || currSum == 0) return new ArrayList<>();

        if(dp[i][currSum] != null) return dp[i][currSum];

        List<Integer> take = new ArrayList<>();
        List<Integer> notTake = helper(i+1, currSum, primes);

        if(primes.get(i) <= currSum) {
            List<Integer> curr = helper(i+1, currSum - primes.get(i), primes);
            take = new ArrayList<>(curr);
            take.add(primes.get(i));
        }

        int sum1 = 0;
        int sum2 = 0;

        Collections.sort(take);
        Collections.sort(notTake);
        for(int ele : take) sum1 += ele;
        for(int ele : notTake) sum2 += ele;

        if(sum1 == 0 && sum2 == 0) return dp[i][currSum] = new ArrayList<>();

        if(sum1 > sum2) return dp[i][currSum] = take;
        else if(sum1 < sum2) return dp[i][currSum] = notTake;
        else {
            if(take.size() < notTake.size()) return dp[i][currSum] = take;
            else if(notTake.size() < take.size()) return dp[i][currSum] = notTake;
            else {
                if(take.get(0) < notTake.get(0)) return dp[i][currSum] = take;
                return dp[i][currSum] = notTake;
            }
        }
    }

    public List<Integer> maxPrimeSubset(int n, int s) {
        List<Integer> primes = getPrimes(n+1);

        int m = primes.size();
        dp = new ArrayList[m+1][s+1];

        return helper(0, s, primes);
    }
}