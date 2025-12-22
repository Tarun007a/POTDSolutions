package GFG;

// tc - O(nlogm), sc - O(1)
class Solution {
    public int rowWithMax1s(int arr[][]) {
        int index = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        int curr = 0;

        for(int[] row : arr){
            int firstOne = getFirstOccurrenceOfOne(row);
            if(firstOne < index){
                index = firstOne;
                result = curr;
            }
            curr++;
        }
        return result;
    }

    public int getFirstOccurrenceOfOne(int [] arr){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = l - (l - r) / 2;
            if(arr[mid] == 1) r = mid - 1;
            else l = mid + 1;
        }
        return r;
    }
}
