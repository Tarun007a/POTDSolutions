package Leetcode;

// leetcode - 1385
// tc - O(nlogn + mlogm), sc - O(1)
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;
        int idx1 = 0;
        int idx2 = 0;
        int result = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < n; i++) {
            int curr = arr1[i];
            int val1 = curr - d;

            while(idx1 < m && arr2[idx1] < val1) idx1++;
            while(idx2 < m && arr2[idx2] < curr) idx2++;

            if(idx1 < m && Math.abs(curr - arr2[idx1]) <= d) continue;
            if(idx2 < m && Math.abs(curr - arr2[idx2]) <= d) continue;
            result++;
        }

        return result;
    }
}

















