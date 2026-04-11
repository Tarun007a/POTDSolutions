package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        int result = 0;
        int size = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) size++;
            else {
                result += (size*(size+1)) / 2 - size;
                size = 1;
            }
        }
        result += (size*(size+1)) / 2 - size;
        return result;
    }
}
