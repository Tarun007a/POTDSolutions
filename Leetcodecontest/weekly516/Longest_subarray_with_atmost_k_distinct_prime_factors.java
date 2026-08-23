package Leetcodecontest.weekly516;

class Solution {
    public boolean[] seive(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i = 2; i*i < n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j < n ;j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    private List<Integer> getPFactors(int num, boolean[] isPrime) {
        List<Integer> result = new ArrayList<>();

        if(isPrime[num]) {
            return List.of(num);
        }

        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) {
                int j = num/i;

                if(isPrime[i]) result.add(i);
                if(i != j && isPrime[j]) result.add(j);
            }
        }
        return result;
    }

    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int result = 0;

        for(int num : nums) max = Math.max(max, num);
        boolean[] isPrime = seive(max+1);

        List<List<Integer>> primeFactors = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : nums) {
            primeFactors.add(getPFactors(num, isPrime));
        }
        // System.out.println(primeFactors);

        int i = 0;
        for(int j = 0; j < n; j++) {
            for(int factor : primeFactors.get(j)) {
                mp.put(factor, mp.getOrDefault(factor, 0)+1);
            }

            while(mp.size() > k) {
                List<Integer> toRemove = primeFactors.get(i);

                for(int f : toRemove) {
                    if(mp.get(f) == 1) mp.remove(f);
                    else mp.put(f, mp.get(f)-1);
                }

                i++;
            }
            result = Math.max(result, j-i+1);
        }
        return result;
    }
}




