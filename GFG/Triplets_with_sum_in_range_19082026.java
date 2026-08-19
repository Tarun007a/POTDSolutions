package GFG;

// tc - O(n*n*logn), sc - O(1)
class Solution {
    private int leftBound(int lo, int hi, int val, int[] arr) {
        int result = -1;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;

            if(arr[mid] >= val) {
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }

    private int rightBound(int lo, int hi, int val, int[] arr) {
        int result = -1;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;

            if(arr[mid] <= val) {
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }

        return result;
    }

    public int countTriplets(int[] arr, int l, int r) {
        int n = arr.length;
        Arrays.sort(arr);
        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if(sum >= r) break;

                int max = r - sum;
                int min = Math.max(l - sum, 0);

                // find fist idx in this range whose val is greater than or equal to min
                int leftIdx = leftBound(j+1, n-1, min, arr);

                // find smaller or equal to max
                int rightIdx = rightBound(j+1, n-1, max, arr);

                // System.out.println(min + " " + max + " " + leftIdx + " " + rightIdx);

                if(leftIdx != -1 && rightIdx != -1 && rightIdx >= leftIdx){
                    result += rightIdx - leftIdx + 1;
                }
            }
        }
        return result;
    }
}