package Leetcode;

// leetcode - 1477
// tc - O(nlogn), sc - O(n)
// class Solution {
//     private int binarySearch(int n, List<List<Integer>> intervals) {
//         int lo = 0;
//         int hi = intervals.size() - 1;
//         int result = -1;

//         while(lo <= hi) {
//             int mid = lo - (lo - hi) / 2;

//             if(intervals.get(mid).get(1) < n) {
//                 result = mid;
//                 lo = mid+1;
//             }
//             else hi = mid-1;
//         }
//         return result;
//     }

//     public int minSumOfLengths(int[] arr, int target) {
//         int n = arr.length;
//         int currSum = 0;
//         int result = Integer.MAX_VALUE;

//         List<List<Integer>> intervals = new ArrayList<>();
//         HashMap<Integer, Integer> mp = new HashMap<>();
//         mp.put(0, -1);

//         for(int i = 0; i < n; i++) {
//             currSum += arr[i];

//             if(mp.containsKey(currSum - target)) {
//                 intervals.add(List.of(mp.get(currSum - target) + 1, i));
//             }

//             mp.put(currSum, i);
//         }

//         int m = intervals.size();

//         if(m < 2) return -1;

//         int[] minArray = new int[m];
//         minArray[0] = intervals.get(0).get(1) - intervals.get(0).get(0) + 1;

//         for(int i = 1; i < m; i++) {
//             minArray[i] = Math.min(minArray[i-1],
//                 intervals.get(i).get(1) - intervals.get(i).get(0) + 1);
//         }

//         for(List<Integer> interval : intervals) {
//             int st = interval.get(0);
//             int end = interval.get(1);
//             int len = end - st + 1;

//             int idx = binarySearch(st, intervals);
//             if(idx != -1) result = Math.min(result, len + minArray[idx]);
//         }

//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
// }


// tc - O(n), sc - O(n)
class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int result = Integer.MAX_VALUE;

        List<List<Integer>> intervals = new ArrayList<>();

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int currSum = 0;

        for (int i = 0; i < n; i++) {

            currSum += arr[i];

            if (mp.containsKey(currSum - target)) {
                intervals.add(List.of(mp.get(currSum - target) + 1, i));
            }
            mp.put(currSum, i);
        }

        int minLen = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < intervals.size(); i++) {

            int st = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            int currLen = end - st + 1;

            while (idx < i && intervals.get(idx).get(1) < st) {

                int prevSt = intervals.get(idx).get(0);
                int prevEnd = intervals.get(idx).get(1);

                int prevLen = prevEnd - prevSt + 1;

                minLen = Math.min(minLen, prevLen);

                idx++;
            }

            if (minLen != Integer.MAX_VALUE) {
                result = Math.min(result, currLen + minLen);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
