// range(10^-4 to 10^4)
// tc - range * log(n) + n, sc - O(n)
// we only try a value once and using binary serach to find the idx of value
// greatest smaller than the value we are trying so we can say in left side
// we need to add something to make it k and in right we need to substract
// this makes trying each number O(n) using prefix sum to get sum
// class Solution {
//     private int binarySerarch(int low, int hi, int val, int[] arr) {
//         int result = low;

//         while(low <= hi) {
//             int mid = hi - (hi - low) / 2;
//             if(arr[mid] <= val) {
//                 result = mid;
//                 low = mid+1;
//             }
//             else hi = mid-1;
//         }
//         return result;
//     }

//     public ArrayList<Integer> optimalArray(int[] arr) {
//         int n = arr.length;
//         ArrayList<Integer> result = new ArrayList<>();
//         int[] prefixSum = new int[n];
//         prefixSum[0] = arr[0];
//         int low = arr[0];

//         for(int i = 1; i < n; i++) prefixSum[i] = prefixSum[i-1] + arr[i];

//         for(int i = 0; i < n; i++) {
//             int hi = arr[i];
//             int prev = -1;

//             for(int j = low; j <= hi; j++) {
//                 int idx = binarySerarch(0, i, j, arr);

//                 int leftCount= idx+1;
//                 int rightCount = i - idx;

//                 int leftSum = prefixSum[idx];
//                 int rightSum = prefixSum[i] - leftSum;

//                 int curr = (j * leftCount - leftSum) + (rightSum - j * rightCount);
//                 if(prev == -1 || prev > curr) prev = curr;
//                 else if(prev <= curr){
//                     low = j-1;
//                     break;
//                 }
//             }
//             result.add(prev);
//         }
//         return result;
//     }
// }


// tc - O(n), sc - O(n)
// for a sorted array the best value is always median so we can find lower bound
// of ele/2 and than we are just directly converting every element to it and
// use prefix sum as we used previously
// class Solution {
//     public ArrayList<Integer> optimalArray(int[] arr) {
//         int n = arr.length;

//         ArrayList<Integer> result = new ArrayList<>();
//         int[] prefixSum = new int[n];
//         prefixSum[0] = arr[0];

//         for(int i = 1; i < n; i++) prefixSum[i] = prefixSum[i-1] + arr[i];

//         for(int i = 0; i < n; i++) {
//             int medianIdx = i/2;
//             int val = arr[medianIdx];

//             int leftSum = prefixSum[medianIdx];
//             int rightSum = prefixSum[i] - leftSum;
//             int leftCount = medianIdx + 1;
//             int rightCount = i - medianIdx;

//             int curr = (val * leftCount - leftSum) + (rightSum - val * rightCount);
//             result.add(curr);
//         }
//         return result;
//     }
// }



// so the median moves very predictlbly let for i, the median was i/2 so for
// next values it will always increase so can just keep a pointer and maintain
// sum till the index and a full sum so we can get the sum of the left and right
// part by just using some variables rather than using a full prefixSum array
// tc - O(n), sc - O(1)
class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int idx = -1;
        int leftSum = 0;
        int totalSum = 0;

        for(int i = 0; i < n; i++) {
            int medianIdx = i/2;
            int val = arr[medianIdx];
            totalSum += arr[i];

            while(idx != medianIdx) {
                idx++;
                leftSum += arr[idx];
            }

            int rightSum = totalSum - leftSum;
            int leftCount = medianIdx + 1;
            int rightCount = i - medianIdx;

            int curr = (val * leftCount - leftSum) + (rightSum - val * rightCount);
            result.add(curr);
        }
        return result;
    }
}




