package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int result = 0;
        int prevGreatest = 0;
        int[] nextGreatest = new int[n];
        nextGreatest[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--) {
            nextGreatest[i] = Math.max(arr[i], nextGreatest[i+1]);
        }

        for(int i = 0; i < n; i++){
            prevGreatest = Math.max(prevGreatest, arr[i]);
            result += Math.min(nextGreatest[i], prevGreatest) - arr[i];
        }
        return result;
    }
}
