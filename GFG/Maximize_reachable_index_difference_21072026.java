package GFG;

// TLE
// class Solution {
//     int[][] dp;

//     private int searchIdx(List<Integer> list, int val) {
//         int lo = 0;
//         int hi = list.size()-1;
//         int result = -1;

//         while(lo <= hi) {
//             int mid = hi - (hi - lo) / 2;
//             if(list.get(mid) > val) {
//                 result = mid;
//                 hi = mid-1;
//             }
//             else lo = mid+1;
//         }
//         return result;
//     }

//     private int helper(int i, int ch, String s, HashMap<Integer, List<Integer>> mp) {
//         if(i == s.length() || ch == 26) return 0;

//         if(dp[i][ch] != -1) return dp[i][ch];

//         int curr = 0;
//         List<Integer> list = mp.get(ch);

//         int stIdx = searchIdx(list, i);
//         if(stIdx == -1) return dp[i][ch] = 0;

//         for(int idx = stIdx; idx < list.size(); idx++) {
//             int newIdx = list.get(idx);
//             curr = Math.max(curr, (newIdx - i) + helper(newIdx, ch+1, s, mp));
//         }
//         return dp[i][ch] = curr;
//     }

//     public int maxIndexDifference(String s) {
//         int n = s.length();
//         dp = new int[n][26];
//         HashMap<Integer, List<Integer>> mp = new HashMap<>();

//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         for(int i = 0; i < 26; i++) mp.put(i, new ArrayList<>());

//         for(int i = 0; i < n; i++) {
//             int key = s.charAt(i) - 'a';
//             mp.get(key).add(i);
//         }

//         int result = -1;
//         for(int idx : mp.get(0)) {
//             result = Math.max(result, helper(idx, 1, s, mp));
//         }
//         return result;
//     }
// }



// tc - O(n), sc - O(1)
class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int stIdx = 0;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        while(stIdx < n && s.charAt(stIdx) != 'a') stIdx++;

        if(stIdx == n) return -1;

        set.add(0);

        for(int i = stIdx; i < n; i++) {
            int currCh = s.charAt(i) - 'a';
            if(currCh == 0) continue;

            boolean isVisitedAll = true;

            for(int j = 0; j < currCh; j++) {
                if(!set.contains(j)) {
                    isVisitedAll = false;
                    break;
                }
            }

            if(isVisitedAll){
                result = i - stIdx;
                set.add(currCh);
            }
        }
        return result;
    }
}


