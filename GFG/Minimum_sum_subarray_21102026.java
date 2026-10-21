package GFG;

// tc - O(n), sc -- O(1)
class Solution {
    public int minSubarraySum(int[] arr) {
        int min = arr[0];
        int result = min;
        int currMin = 0;

        for(int ele : arr) {
            currMin += ele;

            result = Math.min(result, currMin);
            min = Math.min(min, ele);

            if(currMin > 0) currMin = 0;
        }

        result = Math.min(result, min);

        return result;
    }
}
