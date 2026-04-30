package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int n;
    private boolean check(int i, int[] arr) {
        if(i >= n) return true;

        int left = i*2 + 1;
        int right = i*2 + 2;

        if((left < n && arr[left] > arr[i]) || (right < n && arr[right] > arr[i]))
            return false;
        return (check(left, arr) && check(right, arr));
    }
    public boolean isMaxHeap(int[] arr) {
        n = arr.length;
        return check(0, arr);
    }
}