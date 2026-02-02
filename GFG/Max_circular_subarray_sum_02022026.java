package GFG;

// tc - O(n), sc - O(n)
//max using kadanes then handel the circular part
class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;
        int curr = 0;
        int max = arr[0];
        int[] prefixMax = new int[n];
        int sum = 0;
        int prev = 0;

        for(int i = 0; i < n; i++){
            curr += arr[i];
            sum += arr[i];

            max = Math.max(max, curr);
            curr = Math.max(curr, 0);

            prefixMax[i] = Math.max(sum, prev);
            prev = prefixMax[i];
        }

        // System.out.println(Arrays.toString(prefixMax));

        curr = 0;
        for(int i = n-1; i > 0; i--){
            curr += arr[i];
            max = Math.max(curr+prefixMax[i-1], max);
        }

        return max;
    }
}
