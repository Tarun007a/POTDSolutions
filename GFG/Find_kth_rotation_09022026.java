package GFG;

// tc-  O(logn), sc - O(1)
class Solution {
    public int findKRotation(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}