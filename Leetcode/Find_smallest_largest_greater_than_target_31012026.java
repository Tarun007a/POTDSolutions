package Leetcode;

// leetcode - 744
// tc - O(logn), sc - O(1)
class Solution {
    public char nextGreatestLetter(char[] arr, char t) {
        int st = 0;
        int end = arr.length-1;
        int ans = 0;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(arr[mid] == t)st=mid+1;
            else if((int)arr[mid] < (int)t) st = mid+1;
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return arr[ans];
    }
}