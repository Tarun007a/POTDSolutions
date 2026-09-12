package Leetcode;

// leetcode - 3414
// tc - O(n * log(n)), sc - O(n)
class Solution {
    int[] value;
    int[] next;

    List<Integer>[][] dp;

    private List<Integer> helper(int i, int idx, List<List<Integer>> intervals){
        if(idx == 4 || i == intervals.size()) {
            return new ArrayList<>();
        }

        if(dp[i][idx] != null) return dp[i][idx];

        List<Integer> take = new ArrayList<>();
        List<Integer> notTake = new ArrayList<>();

        // take
        int st = intervals.get(i).get(0);
        int end = intervals.get(i).get(1);
        int weight = intervals.get(i).get(2);
        int index = intervals.get(i).get(3);

        take.add(intervals.get(i).get(3));
        List<Integer> curr = helper(next[i], idx+1, intervals);

        for(int ele : curr) take.add(ele);

        // not take
        notTake = helper(i+1, idx, intervals);

        Collections.sort(take);
        Collections.sort(notTake);

        long sum1 = 0;
        long sum2 = 0;

        // System.out.println(take);
        for(int ele : take) sum1 += value[ele];
        for(int ele : notTake) sum2 += value[ele];

        if(sum1 > sum2) return dp[i][idx] = take;
        else if(sum1 < sum2) return dp[i][idx] = notTake;

        int n1 = take.size();
        int n2 = notTake.size();

        for(int j = 0; j < Math.min(n1, n2); j++) {
            if(take.get(j) < notTake.get(j)) return dp[i][idx] = take;
            else if(take.get(j) > notTake.get(j)) return dp[i][idx] = notTake;
        }

        if(n1 < n2) return dp[i][idx] = take;
        return dp[i][idx] = notTake;
    }

    private int getNextIdx(int val, List<List<Integer>> intervals) {
        int lo = 0;
        int hi = intervals.size()-1;
        int result = intervals.size();

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;

            if(intervals.get(mid).get(0) > val) {
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        value = new int[n];
        next = new int[n];
        dp = (List<Integer>[][]) new List[n][4];

        for(int i = 0; i < n; i++) {
            value[i] = intervals.get(i).get(2);
            intervals.get(i).add(i);
        }

        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));

        for(int i = 0; i < n; i++) {
            next[i] = getNextIdx(intervals.get(i).get(1), intervals);
        }

        List<Integer> list = helper(0, 0, intervals);

        int size = list.size();
        int[] result = new int[size];
        for(int i = 0; i < size; i++) result[i] = list.get(i);

        return result;
    }
}
