package GFG;

// tc - O(n), sc - O(1)
class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        int currMax = arr[0];
        int currMin = arr[0];
        int ans = arr[0];

        for(int i = 1; i < n; i++){
            if(arr[i] < 0){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(arr[i], arr[i] * currMax);
            currMin = Math.min(arr[i], arr[i] * currMin);
            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}