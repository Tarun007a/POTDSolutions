package Leetcode;

// leetcode - 3010
// tc - O(n), sc - O(1)
class Solution {
    public int minimumCost(int[] arr) {
        int n = arr.length;
        int firstMin = 51;
        int secMin = 51;
        for(int i = 1; i < n; i++){
            if(arr[i] < firstMin){
                secMin = firstMin;
                firstMin = arr[i];
            }
            else if(arr[i] < secMin)secMin = arr[i];
        }
        return firstMin + secMin + arr[0];
    }
}