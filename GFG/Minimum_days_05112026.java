package GFG;

// binary search on answer
// tc - O(nlogn), sc - O(1)
// class Solution {
//     private boolean isPossible(int mid, String s, int[] p) {
//         int n = p.length;
//         char[] arr = s.toCharArray();

//         for(int i = 0; i < mid; i++) {
//             arr[p[i]] = '?';
//         }

//         for(int i = 1; i < n; i++) {
//             if(arr[i-1] != '?' && arr[i-1] == arr[i]) return false;
//         }
//         return true;
//     }

//     public int getMinimumDays(String s, int[] p) {
//         int n = p.length;
//         int lo = 0;
//         int hi = n;
//         int result = -1;

//         while(lo <= hi) {
//             int mid = lo - (lo - hi) / 2;

//             if(isPossible(mid, s, p)) {
//                 result = mid;
//                 hi = mid-1;
//             }
//             else lo = mid+1;
//         }
//         return result;
//     }
// }









// tc - O(n), sc - O(n)
class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = p.length;
        int count = 0;
        char[] arr = s.toCharArray();

        for(int i = 1; i < n; i++) {
            if(s.charAt(i-1) == s.charAt(i)) count++;
        }

        if(count == 0) return 0;

        for(int i = 0; i < n; i++) {
            int idx = p[i];

            if(idx > 0 && arr[idx-1] == arr[idx]) count--;
            if(idx < n-1 && arr[idx+1] == arr[idx]) count--;

            arr[idx] = '?';
            if(count == 0) return i+1;
        }
        return n;
    }
}



































