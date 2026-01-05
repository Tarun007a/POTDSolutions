package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public void sort012(int[] arr) {
        int lo = 0;
        int mid = 0;
        int hi = arr.length-1;

        while(mid <= hi){
            int ele = arr[mid];
            if(ele == 0){
                arr[mid] = arr[lo];
                arr[lo] = ele;
                lo++;
                mid++;
            }
            else if(ele == 1){
                mid++;
            }
            else{
                arr[mid] = arr[hi];
                arr[hi--] = ele;
            }
        }
    }
}