package GFG;

// tc - O(n), sc - O(1)
class Solution {
    void segregate0and1(int[] arr) {
        int j = arr.length-1;
        int i = 0;

        while(i < j) {
            while(arr[i] == 0 && i < j) i++;
            while(arr[j] == 1 && j > i) j--;
            if(i < j) {
                arr[i++] = 0;
                arr[j--] = 1;
            }
        }
    }
}
