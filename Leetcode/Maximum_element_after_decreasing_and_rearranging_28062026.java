package Leetcode;

// leetcode - 1846
// tc - O(nlogn), sc - O(1)
// class Solution {
//     public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//         int n = arr.length;
//         int max = 1;
//         Arrays.sort(arr);

//         int num = 0;
//         for(int i = 0; i < n; i++) {
//             if(arr[i] != num) max = ++num;
//         }
//         return max;
//     }
// }

// tc - O(n), sc - O(n)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int idx = 1;
        int max = 1;
        int[] count = new int[n+1];

        for(int num : arr) {
            if(num > n) count[n]++;
            else count[num]++;
        }

        for(int i = 0; i < n; i++) {
            while(count[idx] == 0) idx++;
            if(idx > max) max++;
            count[idx]--;
        }
        return max;
    }
}