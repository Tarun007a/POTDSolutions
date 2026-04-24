package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int visibleBuildings(int arr[]) {
        int n = arr.length;
        int largest = 0;
        int result = 0;

        for(int i : arr) {
            if(i >= largest) {
                result++;
                largest = i;
            }
        }
        return result;
    }
}