package Leetcode;

// leetcode - 1520
// tc - O(n) + k(26^2) ~` O(n), sc - O(n)

// max 26 possible intervals, as we should put all occurances of char in one substring
// took about 120 min, but did it myself
class Solution {
    List<List<List<Integer>>> dp;

    private List<Integer> getInterval(int idx, String s, int[] firstIdx, int[] lastIdx) {
        int prevSt = firstIdx[idx];
        int prevEnd = lastIdx[idx];

        while(true) {
            int newSt = prevSt;
            int newEnd = prevEnd;

            for(int i = prevSt; i <= prevEnd; i++) {
                int newIdx = s.charAt(i) - 'a';
                newSt = Math.min(newSt, firstIdx[newIdx]);
                newEnd = Math.max(newEnd, lastIdx[newIdx]);

                // if(idx == 3) System.out.println(newSt + " " + newEnd);
            }

            if(newSt == prevSt && newEnd == prevEnd){
                return List.of(newSt, newEnd);
            }
            prevSt = newSt;
            prevEnd = newEnd;
        }
    }

    private List<List<Integer>> helper(int i, List<List<Integer>> intervals) {
        if(i == intervals.size()) return new ArrayList<>();

        if(dp.get(i) != null) return dp.get(i);

        // take
        int end = intervals.get(i).get(1);

        int j = i+1;
        while(j < intervals.size()) {
            if(intervals.get(j).get(0) > end) break;
            j++;
        }

        List<List<Integer>> list = helper(j, intervals);

        List<List<Integer>> take = new ArrayList<>(list);
        take.add(intervals.get(i));

        // not take
        List<List<Integer>> notTake = helper(i+1, intervals);

        if(take.size() > notTake.size()) {
            dp.set(i, take);
            return take;
        }
        else if(take.size() < notTake.size()) {
            dp.set(i, notTake);
            return notTake;
        }

        int sum1 = 0;
        int sum2 = 0;

        for(int idx = 0; idx < take.size(); idx++) {
            sum1 += take.get(idx).get(1) - take.get(idx).get(0) + 1;
            sum2 += notTake.get(idx).get(1) - notTake.get(idx).get(0) + 1;
        }

        if(sum1 < sum2) {
            dp.set(i, take);
            return take;
        }
        dp.set(i, notTake);
        return notTake;
    }

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] firstIdx = new int[26];
        int[] lastIdx = new int[26];
        List<List<Integer>> intervals = new ArrayList<>();
        dp = new ArrayList<>();

        for(int i = 0; i < n; i++) dp.add(null);

        Arrays.fill(firstIdx, -1);

        for(int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            lastIdx[idx] = i;

            if(firstIdx[idx] == -1) firstIdx[idx] = i;
        }

        for(int idx = 0; idx < 26; idx++) {
            if(firstIdx[idx] == -1) continue;
            intervals.add(getInterval(idx, s, firstIdx, lastIdx));
        }

        Collections.sort(intervals, (a, b) -> {
            if(a.get(0) != b.get(0)) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        // System.out.println(intervals);

        List<List<Integer>> choosen = helper(0, intervals);

        // System.out.println(result);

        List<String> result = new ArrayList<>();

        for(List<Integer> choose : choosen) {
            result.add(s.substring(choose.get(0), choose.get(1)+1));
        }

        return result;
    }
}
