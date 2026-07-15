package GFG;

// tc - O(n), sc - O(n)
// class Solution {
//     public int bitonic(int[] arr) {
//         int n = arr.length;
//         int[] decAhead = new int[n];

//         int len = 0;
//         decAhead[n-1] = 0;

//         for(int i = n-2; i >= 0; i--) {
//             if(arr[i] >= arr[i+1]) len++;
//             else len = 0;

//             decAhead[i] = len;
//         }

//         len = 1;
//         int result = decAhead[0] + 1;

//         for(int i = 1; i < n; i++) {
//             if(arr[i] >= arr[i-1]) len++;
//             else len = 1;

//             result = Math.max(result, len + decAhead[i]);
//         }
//         return result;
//     }
// }




// tc - O(n), sc - O(1)
class Solution {
    public int bitonic(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int maxLen = 1;
        int start = 0;
        int nextStart = 0;
        int j = 0;

        while (j < n - 1) {
            while (j < n - 1 && arr[j] <= arr[j+1]) j++;

            while (j < n - 1 && arr[j] >= arr[j+1]) {
                // adjusting nextStart; this will be executed
                // when we detect the start of the descent
                if (j < n - 1 && arr[j] > arr[j+1])
                    nextStart = j + 1;
                j++;
            }
            maxLen = Math.max(maxLen, j - start+1);
            start = nextStart;
        }
        return maxLen;
    }
}

