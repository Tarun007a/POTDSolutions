package Leetcode;

// leetcode - 1464
// tc - O(n), sc - O(1)
class Solution {
    public int maxProduct(int[] arr) {
        int firstMax = arr[0];
        int secMax = arr[1];
        if(secMax > firstMax){
            int temp = secMax;
            secMax = firstMax;
            firstMax = temp;
        }
        for(int i = 2; i < arr.length; i++){
            if(arr[i] > firstMax){
                secMax = firstMax;
                firstMax = arr[i];
            }
            else if(arr[i] > secMax){
                secMax = arr[i];
            }
        }
        return (secMax-1)*(firstMax-1);
    }
}