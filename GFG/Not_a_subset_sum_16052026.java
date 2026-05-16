package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);
        int found = 0;

        for(int num : arr) {
            if(num > found+1) break;
            found += num;
        }
        return found+1;
    }
}