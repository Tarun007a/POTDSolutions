package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        int idx1 = 0;
        int idx2 = 0;
        int breakPoint = -1;

        for(int i = 0; i < n; i++) {
            if(i < n-1 && arr[i] > arr[i+1]) breakPoint = i+1;
            temp[i] = arr[i];
        }

        if(breakPoint == -1) return;

        idx2 = breakPoint;

        for(int i = 0; i < n; i++) {
            if(idx2 == n || (temp[idx1] < temp[idx2] && idx1 < breakPoint)) arr[i] = temp[idx1++];
            else arr[i] = temp[idx2++];
        }
    }
}