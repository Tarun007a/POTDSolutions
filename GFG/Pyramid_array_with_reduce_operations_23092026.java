package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int prev = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(arr[i] >= prev+1) {
                left[i] = ++prev;
            }
            else {
                left[i] = arr[i];
                prev = arr[i];
            }
        }

        prev = 0;
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] >= prev+1) {
                right[i] = ++prev;
            }
            else {
                right[i] = arr[i];
                prev = arr[i];
            }
        }
        if(n <= 2) return sum - 1;

        for(int i = 1; i < n-1; i++) {
            int min = Math.min(left[i], right[i+1]+1);

            int curr = (min * (min + 1)) / 2 + ((min - 1) * (min)) / 2;

            result = Math.min(result, sum - curr);
        }

        return result;
    }
}