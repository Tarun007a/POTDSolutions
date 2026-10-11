package Leetcodecontest.weekly523;

class Solution {
    private boolean[] seive(int n) {
        boolean[] isPrime = new  boolean[n];

        Arrays.fill(isPrime, true);

        for(int i = 2; i*i < n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public List<Integer> maxPrimes(int n, int s) {
        boolean[] isPrime = seive(n+1);
        int st = 2;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        int sum = 0;

        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                sum += i;
                q.add(i);

                while(sum > s) {
                    if(isPrime[st]) {
                        sum -= st;
                        q.removeFirst();
                    }
                    st++;
                }

                if(result.size() < q.size()) {
                    result = new ArrayList<>(q);
                }
            }
        }
        return result;
    }
}