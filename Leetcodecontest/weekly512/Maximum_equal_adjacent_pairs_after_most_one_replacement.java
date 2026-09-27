package Leetcodecontest.weekly512;

class Solution {
    class Pair {
        int val1;
        int val2;

        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public boolean equals(Object obj) {
            Pair pair = (Pair)obj;
            return (pair.val1 == val1 && pair.val2 == val2);
        }

        public int hashCode() {
            return Objects.hash(val1, val2);
        }

        public String toString() {
            return val1 + "|" + val2;
        }
    }

    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int result = 0;
        HashMap<Pair, Integer> mp = new HashMap<>();
        int extras = 0;

        for(int i = 0; i < n-1; i++) {
            int min = Math.min(nums[i], nums[i+1]);
            int max = Math.max(nums[i], nums[i+1]);
            Pair p = new Pair(min, max);

            mp.put(p, mp.getOrDefault(p, 0) + 1);
            // result = Math.max(result, mp.get(p));
        }

        // System.out.println(mp);

        for(Pair p : mp.keySet()) {
            if(p.val1 == p.val2) {
                extras += mp.get(p);
                continue;
            }

            // int val1Freq = mp.getOrDefault(new Pair(p.val1, p.val1), 0);
            // int val2Freq = mp.getOrDefault(new Pair(p.val2, p.val2), 0);

            int curr = mp.get(p);
            result = Math.max(result, curr);
        }

        return result + extras;
    }
}























